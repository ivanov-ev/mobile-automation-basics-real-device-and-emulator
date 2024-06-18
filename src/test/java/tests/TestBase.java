package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulatorDriver;
import drivers.RealDriver;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    //public static String deviceHost = "emulator";

    @BeforeAll
    @Step("Driver initialization")
    static void beforeAll() {

        //deviceHost = System.setProperty("deviceHost", System.getProperty("deviceHost", "emulator"));


        switch (System.getProperty("deviceHost", "emulator")) {
            case "emulator": {
                Configuration.browser = EmulatorDriver.class.getName();
                break;
            }
            case "real": {
                Configuration.browser = RealDriver.class.getName();
                break;
            }
            case "browserstack": {
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            }
        }
        Configuration.browserSize = null;//this is a Selenide workaround; 'null' means 'testing an app, not a browser page'
        Configuration.timeout = 15000;//30000 is recommended; I shortened it to reduce the time spent on Browserstack
    }

    @BeforeEach
    @Step("Add listener")
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());//Adds logging
        open();//Yet another Selenide workaround. It means 'one should open the app first before testing it'
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        if(System.getProperty("deviceHost", "emulator").equals("browserstack")) {
            String sessionId = Selenide.sessionId().toString();
            System.out.println("Capturing video from Browserstack. SessionId: " + sessionId);
            Attach.addVideo(sessionId);
        }
        Attach.pageSource();
        closeWebDriver();
    }
}