package helsi.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/drivers/saucelabs.properties")
public interface SauceLabsDriverConfig extends Config {
    String login();

    String password();

    String app();

    String deviceName();

    String osVersion();

    String project();

    String build();

    String name();

    String url();
}
