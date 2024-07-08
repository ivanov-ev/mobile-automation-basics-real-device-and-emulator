package tests;

import components.HomePageBottomTab;
import components.SettingsPageAppTheme;
import components.SettingsPageExploreFeed;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.OnboardingPage;
import pages.SettingsPage;
import types.FeedState;

import static io.qameta.allure.Allure.step;
import static types.FeedToggle.*;

import types.FeedToggle;

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

    @Test
    @Feature("Settings")
    @Story("App Theme")
    @DisplayName("'App Theme' options: change the font")
    void changeFontTest() {

    }

    @Test
    @Feature("Settings")
    @Story("App Theme")
    @DisplayName("'App Theme' options: change the theme")
    void changeThemeTest() {

    }

}
