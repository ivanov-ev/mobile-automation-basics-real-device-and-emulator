package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.OnboardingPage;

import static io.qameta.allure.Allure.step;

@Tag("mobile_tests")
@Feature("Onboarding")
@DisplayName("Tests for the Wikipedia application's onboarding steps")
public class OnboardingTest extends TestBase {
    final OnboardingPage onboardingPage = new OnboardingPage();
    final HomePage homePage = new HomePage();

    @Test
    @Story("Follow onboarding steps")
    @DisplayName("Follow onboarding steps")
    void followOnboardingStepsTest() {
        step("The 1st screen: check the first screen's heading, check the add language button, " +
                "check the skip button, and click the continue button:", () -> {
            onboardingPage
                    .checkHeading("The Free Encyclopedia")
                    .checkAddLanguageButtonPresence()
                    .checkSkipButtonPresence()
                    .tapForwardButton();
        });
        step("The 2nd screen: check the text on the screen, check the skip button, " +
                "and click the continue button:", () -> {
            onboardingPage.checkHeading("New ways to explore")
                    .checkSecondaryTextPresence()
                    .checkSkipButtonPresence()
                    .tapForwardButton();
        });
        step("The 3rd screen: check the text on the screen, check the skip button, " +
                "and click the continue button:", () -> {
            onboardingPage.checkHeading("Reading lists with sync")
                    .checkSecondaryTextPresence()
                    .checkSkipButtonPresence()
                    .tapForwardButton();
        });
        step("The 4th screen: check the text on the screen, and click the onboarding completion button:", () -> {
            onboardingPage.checkHeading("Data & Privacy")
                    .checkSecondaryTextPresence()
                    .tapDoneButton();
            homePage.checkMainPageIsOpen();
        });
    }
}
