package config;
import org.aeonbits.owner.Config;

@Config.Sources({

        "classpath:${env}.properties",
        "classpath:local.properties"
})

public interface WebConfig extends Config {

    @Key("browser")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteURL();

}