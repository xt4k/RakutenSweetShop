package autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:env",
        "system:properties",
        "classpath:config/${srv}_driver.properties",
        "classpath:config/app.properties"
})
public interface DriverConfig extends Config {

    @Key("browser")
    String webBrowser();

    @Key("browser.version")
    String webBrowserVersion();

    @Key("browser.size")
    String webBrowserSize();

    @Key("log.type")
    String browserLogType();

    @Key("web.remote.driver.url")
    String webRemoteDriverUrl();

    @Key("web.remote.driver.user")
    String webRemoteDriverUser();

    @Key("web.remote.driver.password")
    String webRemoteDriverPassword();

    @Key("video.storage")
    String videoStorage();

    @Key("base.url")
    String baseUrl();

    @Key("${env:LAMBDA_TEST_USERNAME}")
    String ltUserName();

    @Key("access.key")
    String accessKey();

    @Key("ABCDE")
    @DefaultValue("${env:ABC_DE}")
    //@DefaultValue("default_in_config")
    String webAbcde();

    @Key("${env:LT_USERNAME}")
    @DefaultValue("${env:LT_USERNAME}")
    String ltUserName2();

    @Key("${env:LT_ACCESS_KEY}")
    String accessKey2();
}