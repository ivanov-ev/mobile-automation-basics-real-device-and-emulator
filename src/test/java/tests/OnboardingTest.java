package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.OnboardingPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Android Tests for Wikipedia")
public class OnboardingTest extends TestBase {

    OnboardingPage onboardingPage = new OnboardingPage();
    HomePage homePage = new HomePage();

    @Test
    @Feature("Onboarding")
    @Story("Follow onboarding steps")
    @DisplayName("Follow onboarding steps")
    void FollowOnboardingStepsTest() {
        step("The 1st screen: check the first screen's heading, check the add language button, check the skip button, and click the continue button:", () -> {
            onboardingPage
                    .checkHeading("The Free Encyclopedia\n…in over 300 languages")
                    .checkAddLanguageButtonPresence()
                    .checkSkipButtonPresence(true)
                    .tapForwardButton();
        });
        step("The 2nd screen: check the text on the screen, check the skip button, and click the continue button:", () -> {
            onboardingPage.checkHeading("New ways to explore")
                    .checkSecondaryTextPresence()
                    .checkSkipButtonPresence(true)
                    .tapForwardButton();
        });
        step("The 3rd screen: check the text on the screen, check the skip button, and click the continue button:", () -> {
            onboardingPage.checkHeading("Reading lists with sync")
                    .checkSecondaryTextPresence()
                    .checkSkipButtonPresence(true)
                    .tapForwardButton();
        });
        step("The 4th screen: check the text on the screen, and click the onboarding completion button:", () -> {
            onboardingPage.checkHeading("Data & Privacy")
                    .checkSecondaryTextPresence()
                    .checkSkipButtonPresence(false)
                    .tapDoneButton();
            homePage.checkMainPageIsOpen();
        });
    }
}
