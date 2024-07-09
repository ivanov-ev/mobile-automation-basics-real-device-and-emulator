package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumScrollOptions.with;
import static com.codeborne.selenide.appium.ScrollDirection.DOWN;
import static org.openqa.selenium.By.xpath;

public class SettingsPage {
    private final SelenideElement navigateUp =
            $(xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
    private final SelenideElement exploreFeed = $(byAttribute("text", "Explore Feed")),
            appTheme = $(byAttribute("text", "App theme")),
            showImagesToggle = $(xpath("//android.widget.TextView" +
                    "[@resource-id=\"android:id/title\" and @text=\"Show images\"]/../..//android.widget.Switch" +
                    "[@resource-id=\"org.wikipedia.alpha:id/switchWidget\"]"));
    private final SelenideAppiumElement scrollDownToShowImagesAppium = SelenideAppium.
            $(byAttribute("text", "Show images"));

    @Step("Enter the 'Explore Feed' menu")
    public SettingsPage goToExploreFeed() {
        exploreFeed.click();
        return this;
    }

    @Step("Enter the 'App theme' menu")
    public SettingsPage goToAppTheme() {
        appTheme.click();
        return this;
    }

    @Step("Scroll down to the 'Show Images' toggle")
    public SettingsPage scrollDownToShowImages() {
        scrollDownToShowImagesAppium.scroll(with(DOWN, 3));
        return this;
    }

    @Step("Switch the 'Show Images' toggle")
    public SettingsPage switchShowImagesToggle(boolean targetState) {
        boolean currentState = Boolean.parseBoolean(showImagesToggle.getAttribute("checked"));
        if(currentState != targetState) showImagesToggle.click();
        return this;
    }

    @Step("Exit 'Settings'")
    public SettingsPage exitSettings() {
        navigateUp.click();
        return this;
    }
}
