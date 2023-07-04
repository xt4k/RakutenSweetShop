package helsi.config;

import org.aeonbits.owner.ConfigFactory;

public class Configs {
    public static SauceLabsDriverConfig sauceLabs = ConfigFactory.create(SauceLabsDriverConfig.class, System.getProperties());
    public static LocalDriverConfig mobileDriver = ConfigFactory.create(LocalDriverConfig.class, System.getProperties());
    public static GmailConfig gmail = ConfigFactory.create(GmailConfig.class, System.getProperties());

    public static LocatorConfig locator = ConfigFactory.create(LocatorConfig.class, System.getProperties());

}
