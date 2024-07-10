package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:browserstack.properties"})
public interface BrowserstackConfig extends Config {
    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    String app();

    String device();

    @Key("os_version")
    String osVersion();

    String os();

    String project();

    String build();

    String name();

    @Key("base_url")
    String remote();

    String platform();

    @Key("appium_version")
    String appiumVersion();
}
