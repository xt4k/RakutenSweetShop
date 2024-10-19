package helsi.tests.Ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;

public class IOSAppTest {

    private static AppiumDriver driver;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.7"); // Версія iOS
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone"); // Назва пристрою
        caps.setCapability(MobileCapabilityType.UDID, "YOUR_DEVICE_UDID"); // UDID вашого пристрою
        caps.setCapability(MobileCapabilityType.APP, "/path/to/your_app.ipa"); // Шлях до вашого .ipa або .app файлу
        caps.setCapability("xcodeOrgId", "YOUR_XCODE_ORG_ID"); // Ідентифікатор організації Xcode
        caps.setCapability("xcodeSigningId", "iPhone Developer"); // Метод підпису
        caps.setCapability("automatorName", "XCUITest");

        // Ініціалізація драйвера
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Test
    public void testAppLaunch() {
        // Ваш код для тестування
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
