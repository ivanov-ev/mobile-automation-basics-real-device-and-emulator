package tests;

import components.HomePageBottomTab;
import components.SettingsPageAppTheme;
import components.SettingsPageExploreFeed;
import helpers.Attach;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.OnboardingPage;
import pages.SettingsPage;
import types.FeedState;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static helpers.Attach.screenshotAs;
import static io.qameta.allure.Allure.step;
import static types.FeedToggle.*;
import static types.Font.SERIF;
import static types.Theme.*;

import types.FeedToggle;
import types.Font;
import types.Theme;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class SettingsTest extends TestBase {
    OnboardingPage onboardingPage = new OnboardingPage();
    SettingsPage settingsPage = new SettingsPage();
    SettingsPageAppTheme settingsPageAppTheme = new SettingsPageAppTheme();
    SettingsPageExploreFeed settingsPageExploreFeed = new SettingsPageExploreFeed();
    HomePage homePage = new HomePage();
    HomePageBottomTab homePageBottomTab = new HomePageBottomTab();

    @Tag("mobile_tests")
    @Test
    @Feature("Settings")
    @Story("Explore Feed")
    @DisplayName("'Explore Feed' options: enable or disable feed sections:")
    void enableOrDisableFeedSectionsTest() {
        step("Skip onboarding and close the feed customization announcement", () -> {
            onboardingPage.skipOnboarding();
            homePage.closeCustomizeFeedAnnouncement();
        });
        step("Check that the home page contains all sections:", () -> {
            homePage.checkFeatureArticleSectionVisibility(true)
                    .checkTopReadSectionVisibility(true)
                    .checkPictureOfTheDaySectionVisibility(true)
                    //.checkBecauseYouReadSectionVisibility(true) //TODO: FUTURE_FIX because the section is never displayed
                    .checkInTheNewsSectionVisibility(true)
                    .checkOnThisDaySectionVisibility(true)
                    .checkRandomizerSectionVisibility(true)
                    .checkTodayOnWikipediaSectionVisibility(true)
                    .scrollToTop();
        });
        step("Disable some sections, and check that the home page displays only the remaining sections:", () -> {
            homePageBottomTab.tapMore()
                    .goToSettings();
            settingsPage.goToExploreFeed();
            settingsPageExploreFeed.switchToggle(FEATURED_ARTICLE, true)
                    .switchToggle(TOP_READ, false)
                    .switchToggle(PICTURE_OF_THE_DAY, true)
                    .switchToggle(BECAUSE_YOU_READ, false)
                    .switchToggle(IN_THE_NEWS, true)
                    .switchToggle(ON_THIS_DAY, false)
                    .switchToggle(RANDOMIZER, true)
                    .switchToggle(TODAY_ON_WIKIPEDIA, false)
                    .exitCustomizeFeed();
            settingsPage.exitSettings();
            homePage.checkFeatureArticleSectionVisibility(true)
                    .checkTopReadSectionVisibility(false)
                    .checkPictureOfTheDaySectionVisibility(true)
                    //.checkBecauseYouReadSectionVisibility(false) //TODO: FUTURE_FIX because the section is never displayed
                    .checkInTheNewsSectionVisibility(true)
                    .checkOnThisDaySectionVisibility(false)
                    .checkRandomizerSectionVisibility(true)
                    .checkTodayOnWikipediaSectionVisibility(false);
            //.scrollToTop(); //Todo i do not need this command
        });
        step("Disable all sections via the 'Hide All' menu item, and check that the home page is blank:", () -> {
            homePageBottomTab.tapMore()
                    .goToSettings();
            settingsPage.goToExploreFeed();
            settingsPageExploreFeed.changeFeedStateThroughHamburger(FeedState.HIDE_ALL)
                    .exitCustomizeFeed();
            settingsPage.exitSettings();
            homePage.checkFeatureArticleSectionVisibility(false)
                    .checkTopReadSectionVisibility(false)
                    .checkPictureOfTheDaySectionVisibility(false)
                    //.checkBecauseYouReadSectionVisibility(false) //TODO: FUTURE_FIX because the section is never displayed
                    .checkInTheNewsSectionVisibility(false)
                    .checkOnThisDaySectionVisibility(false)
                    .checkRandomizerSectionVisibility(false)
                    .checkTodayOnWikipediaSectionVisibility(false)
                    .tapCustomizeButton();
        });
        step("Enable all sections via the 'Show All' menu item, and check that the home page is blank:", () -> {
            settingsPageExploreFeed.changeFeedStateThroughHamburger(FeedState.SHOW_ALL)
                    .exitCustomizeFeed();//The app is designed so that it navigates directly to the home page
            // if the previous navigation is the 'Customize' button click on the home page
            homePage.checkFeatureArticleSectionVisibility(true)
                    .checkTopReadSectionVisibility(true)
                    .checkPictureOfTheDaySectionVisibility(true)
                    //.checkBecauseYouReadSectionVisibility(true) //TODO: FUTURE_FIX because the section is never displayed
                    .checkInTheNewsSectionVisibility(true)
                    .checkOnThisDaySectionVisibility(true)
                    .checkRandomizerSectionVisibility(true)
                    .checkTodayOnWikipediaSectionVisibility(true);
        });
    }
    //Todo maybe I will add the "restore defaults' check to the above test.

    @Test
    @Feature("Settings")
    @Story("Explore Feed")
    @DisplayName("'Explore Feed' options: change the order of feed sections")
    void changeOrderOfFeedSectionsTest() {

    }

    @Tag("mobile_tests")
    @Test
    @Feature("Settings")
    @Story("Show Images")
    @DisplayName("'Show Images' option")
    void showImagesTest() {
        step("Skip onboarding and close the feed customization announcement:", () -> {
            onboardingPage.skipOnboarding();
            homePage.closeCustomizeFeedAnnouncement();
        });
        step("Disable the 'Show Images' toggle and check the image disappears:", () -> {
            homePageBottomTab.tapMore()
                    .goToSettings();
            settingsPage.scrollDownToShowImages()
                    .switchShowImagesToggle(false)
                    .exitSettings();
            homePage.checkImages(false);
        });
        step("Enable the 'Show Images' toggle and check the image appears again:", () -> {
            homePageBottomTab.tapMore()
                    .goToSettings();
            settingsPage.scrollDownToShowImages()
                    .switchShowImagesToggle(true)
                    .exitSettings();
            homePage.checkImages(true);
        });
    }

    @Tag("mobile_tests")
    @Test
    @Feature("Settings")
    @Story("App Theme")
    @DisplayName("'App Theme' options: change the font")
    void changeFontTest() {
        step("Skip onboarding:", () -> {
            onboardingPage.skipOnboarding();
        });
        step("Go to the 'App theme' settings:", () -> {
            homePageBottomTab.tapMore()
                    .goToSettings();
            settingsPage.goToAppTheme();
            settingsPageAppTheme.selectFont(SERIF);
        });
        //todo
    }

    @Tag("mobile_tests")
    @EnumSource(Theme.class)
    @ParameterizedTest
    @Feature("Settings")
    @Story("App Theme")
    @DisplayName("'App Theme' options: change the theme")
    void changeThemeTest(Theme theme) {
        step("Skip onboarding:", () -> {
            onboardingPage.skipOnboarding();
        });
        step("Go to the 'App theme' settings:", () -> {
            homePageBottomTab.tapMore()
                    .goToSettings();
            settingsPage.goToAppTheme();
        });
        step("Allow all 4 themes to be selected:", () -> {
            settingsPageAppTheme.switchMatchSystemThemeToggle(false);
        });
        step("Select the theme and verify:", () -> {
            settingsPageAppTheme.selectTheme(theme);
            settingsPageAppTheme.exitAppTheme();
            Attach.screenshotAs("Last screenshot"); //delete this if it does not work
            homePage.checkSelectedThemeColor(theme);
        });

    }

    // I can add the match system theme test by operating the "enabled" attribute (2 of 4 are enabled)

}
