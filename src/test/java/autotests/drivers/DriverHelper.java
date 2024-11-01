package autotests.drivers;

import autotests.config.DriverConfig;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static java.lang.String.join;
import static java.util.Optional.ofNullable;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class DriverHelper {

    public static DriverConfig getDriverConfig() {
        return ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid", "");
    }

    public static String getConsoleLogs(String sessionId) {
        String consoleLog;
        String logType = ofNullable(getDriverConfig().browserLogType()).orElse(BROWSER);
        consoleLog = join("\n", getWebDriverLogs(logType));
        return consoleLog;
    }

    @Step("WebDriver configuring")
    public static void configureDriver() {
        addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if ("chrome".equals(getDriverConfig().webBrowser())) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--safebrowsing-disable-download-protection");
            chromeOptions.addArguments("--use-fake-ui-for-media-stream");
            chromeOptions.addArguments("--safebrowsing-disable-extension-blacklist");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("disable-infobars");

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.prompt_for_download", false);
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            chromeOptions.setExperimentalOption("prefs", prefs);
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        }
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl=getDriverConfig().baseUrl();
    }
}