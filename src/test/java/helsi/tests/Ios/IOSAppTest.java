package helsi.tests.Ios;

import groovy.util.logging.Slf4j;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;


@Tags({@Tag("anna"), @Tag("live")})
@Slf4j
public class IOSAppTest {

    private static final Logger log = LoggerFactory.getLogger(IOSAppTest.class);
    private static AppiumDriver driver;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.7"); // Версія iOS
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X"); // Назва пристрою
        caps.setCapability(MobileCapabilityType.UDID, "98c580f3abe2c0090797593faa1a9eee6f676637"); // UDID вашого пристрою
        // caps.setCapability(MobileCapabilityType.APP,"com.google.Docs" );//"/path/to/your_app.ipa"); // Шлях до вашого .ipa або .app файлу
        caps.setCapability("bundleId", "com.google.Docs");
        caps.setCapability("xcodeOrgId", "Yuriy L"); // Ідентифікатор організації Xcode
        caps.setCapability("xcodeSigningId", "iPhone Developer"); // Метод підпису
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability("showXcodeLog", true);



        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        //caps.setCapability(MobileCapabilityType.FULL_RESET, true);

        // Ініціалізація драйвера
        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), caps);//"http://127.0.0.1:4723/session"// "http://127.0.0.1:4723/wd/hub"
    }

    //http://127.0.0.1:4723/wd/hub/status

    @Test
    public void testAppLaunch() {
        addListener("AllureSelenide", new AllureSelenide());
       // driver.m m;;' m

        open();
        log.info("open notes");
        step("open notes");

        //    ((AndroidDriver) getWebDriver()).startRecordingScreen(new AndroidStartScreenRecordingOptions()
        //            .withTimeLimit(Duration.ofSeconds(40)));
      //  back();
        //back();
      //  $(AppiumBy.accessibilityId("HELSI")).click();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
