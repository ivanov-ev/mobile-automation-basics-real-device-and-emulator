package components;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import types.Theme;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SettingsPageAppTheme {
    private final SelenideElement themeLightButton = $(id("org.wikipedia.alpha:id/button_theme_light")),
            themeSepiaButton = $(id("org.wikipedia.alpha:id/button_theme_sepia")),
            themeDarkButton = $(id("org.wikipedia.alpha:id/button_theme_dark")),
            themeBlackButton = $(id("org.wikipedia.alpha:id/button_theme_black"));
    private final SelenideElement matchSystemThemeToggle = $(id("org.wikipedia.alpha:id/theme_chooser_match_system_theme_switch"));

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

    @Step("Switch the 'Match System Theme' toggle")
    public SettingsPageAppTheme switchMatchSystemThemeToggle(boolean targetState) {
        boolean currentState = Boolean.parseBoolean(matchSystemThemeToggle.getAttribute("checked"));
        if(currentState != targetState) matchSystemThemeToggle.click();
        return this;
    }

    @Step("Check the number of active themes")
    public int checkNumberOfActiveTheme() {
        int numberOfActiveThemes = 0;
        if (Boolean.parseBoolean(themeLightButton.getAttribute("enabled"))) numberOfActiveThemes++;
        if (Boolean.parseBoolean(themeSepiaButton.getAttribute("enabled"))) numberOfActiveThemes++;
        if (Boolean.parseBoolean(themeDarkButton.getAttribute("enabled"))) numberOfActiveThemes++;
        if (Boolean.parseBoolean(themeBlackButton.getAttribute("enabled"))) numberOfActiveThemes++;
        System.out.println(numberOfActiveThemes);
        return numberOfActiveThemes;
    }

    @Step("Exit 'App theme'")
    public SettingsPageAppTheme exitAppTheme() {
        Selenide.back();
        Selenide.back();
        return this;
    }
}
