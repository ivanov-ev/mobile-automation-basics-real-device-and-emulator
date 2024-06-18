package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingPage {

    private final SelenideElement primaryTextView = $(id("org.wikipedia.alpha:id/primaryTextView")),
            secondaryTextView = $(id("org.wikipedia.alpha:id/secondaryTextView")),
            addLanguageButton =   $(id("org.wikipedia.alpha:id/addLanguageButton")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")),
            forwardButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            doneButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    public OnboardingPage checkHeading (String headingText) {
        primaryTextView.shouldHave(text(headingText));
        return this;
    }

    public OnboardingPage checkSecondaryTextPresence () {
        secondaryTextView.should(exist);
        return this;
    }

    public OnboardingPage checkAddLanguageButtonPresence () {
        addLanguageButton.should(exist);
        return this;
    }

    public OnboardingPage checkSkipButtonPresence () {
        skipButton.should(exist);
        return this;
    }

    public OnboardingPage tapForwardButton () {
        forwardButton.click();
        return this;
    }

    public OnboardingPage tapDoneButton () {
        doneButton.click();
        return this;
    }
}
