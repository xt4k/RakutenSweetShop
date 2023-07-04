package helsi.drivers;

import com.codeborne.selenide.WebDriverProvider;
import helsi.config.Configs;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;


public class LocalDriverAndroid implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL(Configs.mobileDriver.serverUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(Configs.mobileDriver.platformName())
                .setDeviceName(Configs.mobileDriver.deviceName())
                .setAppPackage(Configs.mobileDriver.appPackage())
                .setAppActivity(Configs.mobileDriver.appActivity())
                .setPlatformVersion(Configs.mobileDriver.platformVersion())
                .setLocale(Configs.mobileDriver.locale())
                .setLanguage(Configs.mobileDriver.language())
                .setCapability("appium:newCommandTimeout", Configs.mobileDriver.timeout());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

}