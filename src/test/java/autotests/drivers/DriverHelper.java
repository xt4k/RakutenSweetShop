package autotests.drivers;

import autotests.config.DriverConfig;
import autotests.tests.TestBase;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class DriverHelper {
    private static final Logger LOG = LoggerFactory.getLogger(TestBase.class);

    public static DriverConfig getDriverConfig() {
        return ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());
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


            prefs.put("selenium_version", "4.23.0");
            prefs.put("w3c", true);

            chromeOptions.setExperimentalOption("prefs", prefs);
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

            if (getDriverConfig().webRemoteDriverUrl() != null && !getDriverConfig().webRemoteDriverUrl().isEmpty()) {
                capabilities.setCapability("LT:Options", Map.of(
                        "username", System.getenv("LT_ACCESS_KEY"),// getDriverConfig().ltUserName(),
                        "accessKey", System.getenv("LT_ACCESS_KEY"),//getDriverConfig().accessKey(),
                        "project", "Untitled",
                        "build", "build-name",
                        "name", "test-name"
                ));

                capabilities.setCapability("selenoid:options", Map.of("enableVNC", true, "enableVideo", true)); // Example options for Selenoid
                capabilities.setCapability("browserName", getDriverConfig().webBrowser());
                capabilities.setCapability("browserVersion", getDriverConfig().webBrowserVersion());
                Configuration.remote = getDriverConfig().webRemoteDriverUrl();

            }
        }

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = getDriverConfig().baseUrl();
        LOG.warn("system emv secret "+ System.getenv("LT_ACCESS_KEY"));
        LOG.warn("LT_UN: " + getDriverConfig().ltUserName());
    }
}