package com.demoqa.tests;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${confProp}.properties"
})
public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1024x768")
    String getBrowserSize();

    @Key("remote")
    String getRemote();
}