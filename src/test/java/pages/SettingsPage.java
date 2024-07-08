package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import components.HomePageBottomTab;
import components.SettingsPageExploreFeed;
import io.qameta.allure.Step;

import java.util.Objects;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumScrollOptions.with;
import static com.codeborne.selenide.appium.ScrollDirection.DOWN;
import static com.codeborne.selenide.appium.ScrollDirection.UP;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class SettingsPage {
    private final SelenideElement navigateUp =  $(xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
    private final SelenideElement exploreFeed = $(byAttribute("text", "Explore Feed")),

    appTheme = $(byText("App theme")).parent(),
    showImages = $(byText("Show images")),
    showImagesToggle = $(xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Show images\"]/../..//android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/switchWidget\"]"));
            //showImages.$(id("org.wikipedia.alpha:id/switchWidget")); // it has the attribute "checked" = false

    private final SelenideAppiumElement scrollDownToShowImagesAppium = SelenideAppium.$(byAttribute("text", "Show images"));


    //Probably the method does not refresh its state, and it is always considered as checked=true because of the way Selenide works.
    @Step("Switch the 'Show Images' toggle")
    public SettingsPage switchShowImagesToggle(boolean targetState) {
        boolean currentState = Boolean.parseBoolean(showImagesToggle.getAttribute("checked"));
        if(currentState != targetState) showImagesToggle.click();
        return this;
    }

    @Step("Enter the 'App theme' menu")
    public SettingsPage goToAppTheme() {
        appTheme.click();
        return this;
    }

    @Step("Enter the 'Explore Feed' menu")
    public SettingsPage goToExploreFeed() {
        exploreFeed.click();
        return this;
    }

    @Step("Exit 'Settings'")
    public SettingsPage exitSettings() {
        navigateUp.click();
        return this;
    }

    @Step("Scroll down to the 'Show Images' toggle")
    public SettingsPage scrollDownToShowImages() {
        scrollDownToShowImagesAppium.scroll(with(DOWN, 3));
        return this;
    }
}
