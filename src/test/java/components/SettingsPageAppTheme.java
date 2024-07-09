package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.*;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.qameta.allure.Step;
import pages.SettingsPage;
import types.Font;
import types.Theme;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.appium.java_client.AppiumBy.id;
import static io.appium.java_client.android.nativekey.AndroidKey.BACK;
import static org.openqa.selenium.By.xpath;

public class SettingsPageAppTheme {
    private final SelenideElement navigateUp =
            $(xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));

    private final SelenideAppiumElement line = SelenideAppium.$(xpath("//android.widget.FrameLayout[@resource-id=\"org.wikipedia.alpha:id/design_bottom_sheet\"]"));

    private final SelenideElement fontSansSerifButton =  $(id("org.wikipedia.alpha:id/button_font_family_sans_serif")),
            fontSerifButton =  $(id("org.wikipedia.alpha:id/button_font_family_serif"));
    private final SelenideElement themeLightButton = $(id("org.wikipedia.alpha:id/button_theme_light")),
            themeSepiaButton = $(id("org.wikipedia.alpha:id/button_theme_sepia")),
            themeDarkButton = $(id("org.wikipedia.alpha:id/button_theme_dark")),
            themeBlackButton = $(id("org.wikipedia.alpha:id/button_theme_black"));
    private final SelenideElement matchSystemThemeToggle = $(id("org.wikipedia.alpha:id/theme_chooser_match_system_theme_switch"));


    @Step("Select the font")
    public SettingsPageAppTheme selectFont(Font targetFont) {
        switch (targetFont) {
            case SANS_SERIF: {
                fontSansSerifButton.click();
                break;
            }
            case SERIF: {
                fontSerifButton.click();
                break;
            }
        }
        return this;
    }

    @Step("Select the theme")
    public SettingsPageAppTheme selectTheme(Theme targetTheme) {
        switch (targetTheme) {
            case LIGHT: {
                themeLightButton.click();
                break;
            }
            case SEPIA: {
                themeSepiaButton.click();
                break;
            }
            case DARK: {
                themeDarkButton.click();
                break;
            }
            case BLACK: {
                themeBlackButton.click();
                break;
            }
        }
        return this;
    }

    //Probably the method does not refresh its state, and it is always considered as checked=true because of the way Selenide works.
    @Step("Switch the 'Match System Theme' toggle")
    public SettingsPageAppTheme switchMatchSystemThemeToggle(boolean targetState) {
        boolean currentState = Boolean.parseBoolean(matchSystemThemeToggle.getAttribute("checked"));
        if(currentState != targetState) matchSystemThemeToggle.click();
        return this;
    }

    @Step("Exit 'App theme'")
    public SettingsPageAppTheme exitAppTheme() {
        SelenideAppium.back();
        SelenideAppium.back();
        return this;
    }
}
