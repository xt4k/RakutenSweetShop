package helsi.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helsi.helpers.Attach;
import helsi.helpers.DriverSettings;
import helsi.pages.android.MainPage;
import helsi.pages.android.SearchPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helsi.helpers.Attach.sessionId;
import static io.qameta.allure.Allure.step;


public class TestBase {
    private static final Logger log = LoggerFactory.getLogger(TestBase.class);
    private static String deviceProvider = System.getProperty("deviceProvider", "mobile");

    public MainPage mainPage = new MainPage();

    public SearchPage searchPage = new SearchPage();

    @BeforeAll
    public static void setup() {

        log.info("deviceProvider: "+deviceProvider);
        Configuration.browser = DriverSettings.getDeviceProvider(deviceProvider);
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    //    ((AndroidDriver) getWebDriver()).startRecordingScreen(new AndroidStartScreenRecordingOptions()
    //            .withTimeLimit(Duration.ofSeconds(40)));
        back();
        back();
        $(AppiumBy.accessibilityId("HELSI")).click();

    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        String base64output = ((AndroidDriver) getWebDriver()).stopRecordingScreen();
        step("Close driver", Selenide::closeWebDriver);

        if (deviceProvider.contains("saucelabs")) {
            Attach.video(sessionId);
        }
     //   saveVideoLocally(sessionId, base64output);
    }




}
