package tests;

import components.HomePageBottomTab;
import components.SettingsPageAppTheme;
import components.SettingsPageExploreFeed;
import helpers.Attach;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.HomePage;
import pages.OnboardingPage;
import pages.SettingsPage;
import types.FeedState;

import static io.qameta.allure.Allure.step;
import static types.FeedToggle.*;

import types.Theme;

@Tag("mobile_tests")
@Feature("Settings")
@DisplayName("Tests for the Wikipedia application settings")
public class SettingsTest extends TestBase {
    OnboardingPage onboardingPage = new OnboardingPage();
    SettingsPage settingsPage = new SettingsPage();
    SettingsPageAppTheme settingsPageAppTheme = new SettingsPageAppTheme();
    SettingsPageExploreFeed settingsPageExploreFeed = new SettingsPageExploreFeed();
    HomePage homePage = new HomePage();
    HomePageBottomTab homePageBottomTab = new HomePageBottomTab();

    @Test
    @Story("Explore Feed")
    @DisplayName("The 'Explore Feed' options: enable or disable feed sections")
    void enableOrDisableFeedSectionsTest() {
        step("Skip onboarding and close the feed customization announcement", () -> {
            onboardingPage.skipOnboarding();
            homePage.closeCustomizeFeedAnnouncement();
        });
        step("Check that the home page contains all sections:", () -> {
            homePage.checkFeatureArticleSectionVisibility(true)
                    .checkTopReadSectionVisibility(true)
                    .checkPictureOfTheDaySectionVisibility(true)
                    //.checkBecauseYouReadSectionVisibility(true) //TODO: FUTURE_FIX the section is never displayed
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
                    //.checkBecauseYouReadSectionVisibility(false) //TODO: FUTURE_FIX the section is never displayed
                    .checkInTheNewsSectionVisibility(true)
                    .checkOnThisDaySectionVisibility(false)
                    .checkRandomizerSectionVisibility(true)
                    .checkTodayOnWikipediaSectionVisibility(false);
        });
    }

    @Test
    @Story("Explore Feed")
    @DisplayName("The 'Explore Feed' options: enable or disable feed sections through the hamburger button")
    void enableOrDisableFeedSectionsThroughHamburgerTest() {
        step("Skip onboarding and close the feed customization announcement", () -> {
            onboardingPage.skipOnboarding();
            homePage.closeCustomizeFeedAnnouncement();
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
                    //.checkBecauseYouReadSectionVisibility(false) //TODO: FUTURE_FIX the section is never displayed
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
                    //.checkBecauseYouReadSectionVisibility(true) //TODO: FUTURE_FIX the section is never displayed
                    .checkInTheNewsSectionVisibility(true)
                    .checkOnThisDaySectionVisibility(true)
                    .checkRandomizerSectionVisibility(true)
                    .checkTodayOnWikipediaSectionVisibility(true);
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
                    //.checkBecauseYouReadSectionVisibility(false) //TODO: FUTURE_FIX the section is never displayed
                    .checkInTheNewsSectionVisibility(false)
                    .checkOnThisDaySectionVisibility(false)
                    .checkRandomizerSectionVisibility(false)
                    .checkTodayOnWikipediaSectionVisibility(false)
                    .tapCustomizeButton();
        });
        step("Enable all sections via the 'Restore Default View' item, and check the home page is blank:", () -> {
            settingsPageExploreFeed.changeFeedStateThroughHamburger(FeedState.RESTORE)
                    .exitCustomizeFeed();//The app is designed so that it navigates directly to the home page
            // if the previous navigation is the 'Customize' button click on the home page
            homePage.checkFeatureArticleSectionVisibility(true)
                    .checkTopReadSectionVisibility(true)
                    .checkPictureOfTheDaySectionVisibility(true)
                    //.checkBecauseYouReadSectionVisibility(true) //TODO: FUTURE_FIX the section is never displayed
                    .checkInTheNewsSectionVisibility(true)
                    .checkOnThisDaySectionVisibility(true)
                    .checkRandomizerSectionVisibility(true)
                    .checkTodayOnWikipediaSectionVisibility(true);
        });
    }

    @Test
    @Story("Show Images")
    @DisplayName("The 'Show Images' option")
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

    @EnumSource(Theme.class)
    @ParameterizedTest
    @Story("App Theme")
    @DisplayName("The 'App Theme' options: change the theme")
    void changeThemeTest(Theme theme) {
        step("Skip onboarding:", () -> {
            onboardingPage.skipOnboarding();
        });
        step("Go to the 'App theme' settings:", () -> {
            homePageBottomTab.tapMore()
                    .goToSettings();
            settingsPage.goToAppTheme();
        });
        if (System.getProperty("deviceHost", "emulator").equals("emulator")) {
            step("Allow all 4 themes to be selected:", () -> {
                settingsPageAppTheme.switchMatchSystemThemeToggle(false);
            });
        }
        step("Select the theme and verify:", () -> {
            settingsPageAppTheme.selectTheme(theme);
            settingsPageAppTheme.exitAppTheme();
            Attach.screenshotAs("Selected theme's screenshot");
            homePage.checkSelectedThemeColor(theme);
        });
    }
    
    @Test
    @Story("App Theme")
    @DisplayName("The 'App Theme' options: check the 'Match system theme' toggle")
    void checkMatchSystemThemeToggleTest() {
        if(System.getProperty("deviceHost", "emulator").equals("emulator")) {
            step("Skip onboarding:", () -> {
                onboardingPage.skipOnboarding();
            });
            step("Go to the 'App theme' settings:", () -> {
                homePageBottomTab.tapMore()
                        .goToSettings();
                settingsPage.goToAppTheme();
            });
            step("Check the number of active themes = 2:", () -> {
                Assertions.assertEquals(2, settingsPageAppTheme.checkNumberOfActiveTheme());
            });
            step("Turn off the 'Match system theme' toggle:", () -> {
                settingsPageAppTheme.switchMatchSystemThemeToggle(false);
            });
            step("Check the number of active themes = 4:", () -> {
                Assertions.assertEquals(4, settingsPageAppTheme.checkNumberOfActiveTheme());
            });
            step("Turn on the 'Match system theme' toggle:", () -> {
                settingsPageAppTheme.switchMatchSystemThemeToggle(true);
            });
            step("Check the number of active themes = 2:", () -> {
                Assertions.assertEquals(2, settingsPageAppTheme.checkNumberOfActiveTheme());
            });
        }
        else {
            Allure.addAttachment("Comment", "text/plain", "Test skipped!\n" +
                    "Neither my Android phone, nor the Browserstack service displays the 'Match system theme' toggle",
                    ".txt");
        }
    }
}
