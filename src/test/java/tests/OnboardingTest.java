package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.OnboardingPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@DisplayName("Android Tests for Wikipedia")
public class OnboardingTest extends TestBase {

    //Todo: Test on the real device, test on browserstack, add Jira with AllureReport

    OnboardingPage onboardingPage = new OnboardingPage();
    HomePage homePage = new HomePage();

    @Test
    @Feature("Onboarding")
    @Story("Follow onboarding steps")
    @DisplayName("Follow onboarding steps")
    void FollowOnboardingStepsTest() {
        step("The 1st screen: check the first screen's heading, check the add language button, check the skip button, and click the continue button:", () -> {

//            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia\\n…in over 300 languages"));
//            $(id("org.wikipedia.alpha:id/addLanguageButton")).should(exist);
//            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).should(exist);
//            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();

            onboardingPage
                    .checkHeading("The Free Encyclopedia\n…in over 300 languages")
                    .checkAddLanguageButtonPresence()
                    .checkSkipButtonPresence(true)
                    .tapForwardButton();
        });
        step("The 2nd screen: check the text on the screen", () -> {

//            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
//            $(id("org.wikipedia.alpha:id/secondaryTextView")).should(exist);
//            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).should(exist);
//            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();

            onboardingPage.checkHeading("New ways to explore")
                    .checkSecondaryTextPresence()
                    .checkSkipButtonPresence(true)
                    .tapForwardButton();
        });
        step("The 3rd screen: check the text on the screen", () -> {

//            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
//            $(id("org.wikipedia.alpha:id/secondaryTextView")).should(exist);
//            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).should(exist);
//            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();

            onboardingPage.checkHeading("Reading lists with sync")
                    .checkSecondaryTextPresence()
                    .checkSkipButtonPresence(true)
                    .tapForwardButton();
        });

        step("The 4th screen: check the text on the screen", () -> {

//            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Data & Privacy"));
//            $(id("org.wikipedia.alpha:id/secondaryTextView")).should(exist);
//            $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).shouldNot(exist);
//            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
//            $(id("org.wikipedia.alpha:id/search_container")).should(exist);

            onboardingPage.checkHeading("Data & Privacy")
                    .checkSecondaryTextPresence()
                    .checkSkipButtonPresence(false)
                    .tapDoneButton();
            homePage.checkMainPageIsOpen();
        });
    }
}
