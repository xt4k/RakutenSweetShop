package helsi.drivers;

import com.codeborne.selenide.WebDriverProvider;
import helsi.config.Configs;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class SauceLabsDriver implements WebDriverProvider {
    public static URL getSauceLabsUrl() {
        try {
            return new URL(Configs.sauceLabs.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("saucelabs.appium_version", "1.22.0");
        mutableCapabilities.setCapability("saucelabs.user", Configs.sauceLabs.login());
        mutableCapabilities.setCapability("saucelabs.key", Configs.sauceLabs.password());
        mutableCapabilities.setCapability("app", Configs.sauceLabs.app());
        mutableCapabilities.setCapability("device", Configs.sauceLabs.deviceName());
        mutableCapabilities.setCapability("os_version", Configs.sauceLabs.osVersion());
        mutableCapabilities.setCapability("project", Configs.sauceLabs.project());
        mutableCapabilities.setCapability("build", Configs.sauceLabs.build());
        mutableCapabilities.setCapability("name", Configs.sauceLabs.name());

        return new RemoteWebDriver(getSauceLabsUrl(), mutableCapabilities);
    }
}