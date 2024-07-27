package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class BrowserstackDriver implements WebDriverProvider {

    final BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<>();

        // Set your access credentials
        browserstackOptions.put("userName", browserstackConfig.browserstackUser());
        browserstackOptions.put("accessKey", browserstackConfig.browserstackKey());

        // Set URL of the application under test
        caps.setCapability("app", browserstackConfig.app());

        // Specify device and os_version for testing
        browserstackOptions.put("deviceName", browserstackConfig.device());
        browserstackOptions.put("os", browserstackConfig.os());
        browserstackOptions.put("osVersion", browserstackConfig.osVersion());

        // Set other BrowserStack capabilities
        browserstackOptions.put("projectName", browserstackConfig.project());
        browserstackOptions.put("buildName", browserstackConfig.build());
        browserstackOptions.put("sessionName", browserstackConfig.name());
        caps.setCapability("platformName", browserstackConfig.platform());

        //Set Appium version
        browserstackOptions.put("appiumVersion", browserstackConfig.appiumVersion());

        //Combine the above 'browserstackOptions' options into a JSON body or something
        caps.setCapability("bstack:options", browserstackOptions);

        // Initialise the remote driver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new AndroidDriver(
                    // This init works only with 'AndroidDriver'.
                    // If 'RemoteWebDriver' is specified here instead of 'AndroidDriver', then the driver opens a blank
                    // page in the embedded Chrome browser rather than the Android application.
                    new URI(browserstackConfig.remote()).toURL(), caps);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
