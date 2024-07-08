package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import types.FeedToggle;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.ScrollDirection.DOWN;
import static com.codeborne.selenide.appium.ScrollDirection.UP;
import static io.appium.java_client.AppiumBy.id;
import static io.appium.java_client.touch.offset.PointOption.point;
import static org.openqa.selenium.By.xpath;


import static com.codeborne.selenide.appium.AppiumScrollOptions.with;
import static com.codeborne.selenide.appium.AppiumScrollOptions.down;
import static com.codeborne.selenide.appium.AppiumScrollOptions.up;

public class HomePage {
    private final SelenideElement searchWikipediaContainer = $(id("org.wikipedia.alpha:id/search_container"));
    private final SelenideAppiumElement searchWikipediaContainerAppium = SelenideAppium.$(id("org.wikipedia.alpha:id/search_container"));

    //If everything works fine, each section can be moved to a separate component.
    private final SelenideElement featureArticleSection = $(byAttribute("text", "Featured article")),
            topReadSection = $(byAttribute("text", "Top read")),
            pictureOfTheDaySection = $(byAttribute("text", "Picture of the day")),
            becauseYouReadSection = $(byAttribute("text", "Because you read")), //Todo this section will not appear until I open any article!!! Create a preparation step.
            inTheNewsSection = $(byAttribute("text", "In the news")),
            onThisDaySection = $(byAttribute("text", "On this day")),
            randomizerSection = $(byAttribute("text", "Random article")),
            todayOnWikipediaSection = $(byAttribute("text", "Today on Wikipedia"));
    private final SelenideAppiumElement featureArticleSectionAppium = SelenideAppium.$(byAttribute("text", "Featured article")),
            topReadSectionAppium = SelenideAppium.$(byAttribute("text", "Top read")),
            pictureOfTheDaySectionAppium = SelenideAppium.$(byAttribute("text", "Picture of the day")),
            becauseYouReadSectionAppium = SelenideAppium.$(byAttribute("text", "Because you read")), //Todo this section will not appear until I open any article!!! Create a preparation step.
            inTheNewsSectionAppium = SelenideAppium.$(byAttribute("text", "In the news")),
            onThisDaySectionAppium = SelenideAppium.$(byAttribute("text", "On this day")),
            randomizerSectionAppium = SelenideAppium.$(byAttribute("text", "Random article")),
            todayOnWikipediaSectionAppium = SelenideAppium.$(byAttribute("text", "Today on Wikipedia"));

    private final SelenideElement customizeButton = $(xpath("//android.widget.Button[@resource-id=\"org.wikipedia.alpha:id/customize_button\"]"));
    private final SelenideElement gotItButton = $(id("org.wikipedia.alpha:id/view_announcement_action_negative"));
    private final SelenideElement blankFeedLabel = $(xpath("//android.widget.TextView[@text=\"There's nothing on your Explore feed\"]"));
    private final SelenideElement featuredArticleImage = $(xpath("//android.widget.ImageView[@resource-id=\"org.wikipedia.alpha:id/articleImage\"]"));




    public void checkMainPageIsOpen() {
        searchWikipediaContainer.should(exist);
    }

    @Step("Check the 'Feature Article' section visibility on the home page. " +
            "'True' = visible, 'false' = invisible. The value passed to the method = '{visible}'")
    public HomePage checkFeatureArticleSectionVisibility(boolean visible) {
//        if (visible) featureArticleSection.should(exist);
//        else featureArticleSection.should(not(exist));
        if (visible) featureArticleSectionAppium.scroll(with(DOWN, 10));
        else {
            if (!fastCheckHomePageBlank()) {
                for (int i = 0; i < 10; i++)
                    featureArticleSectionAppium.scroll(with(DOWN, 1)).should(not(exist));
            }
        }
        return this;
    }

    @Step("Check the 'Top Read' section visibility on the home page. " +
            "'True' = visible, 'false' = invisible. The value passed to the method = '{visible}'")
    public HomePage checkTopReadSectionVisibility(boolean visible) {
//        if (visible) topReadSection.should(exist);
//        else topReadSection.should(not(exist));
        if (visible) topReadSectionAppium.scroll(with(DOWN, 10));
        else {
            if (!fastCheckHomePageBlank()) {
                for (int i = 0; i < 10; i++)
                    topReadSectionAppium.scroll(with(DOWN, 1)).should(not(exist));
            }
        }
        return this;
    }

    @Step("Check the 'Picture Of The Day' section visibility on the home page. " +
            "'True' = visible, 'false' = invisible. The value passed to the method = '{visible}'")
    public HomePage checkPictureOfTheDaySectionVisibility(boolean visible) {
//        if (visible) pictureOfTheDaySection.should(exist);
//        else pictureOfTheDaySection.should(not(exist));
        if (visible) pictureOfTheDaySectionAppium.scroll(with(DOWN, 10));
        else {
            if (!fastCheckHomePageBlank()) {
                for (int i = 0; i < 10; i++)
                    pictureOfTheDaySectionAppium.scroll(with(DOWN, 1)).should(not(exist));
            }
        }
        return this;
    }

    @Step("Check the 'Because You Read' section visibility on the home page. " +
            "'True' = visible, 'false' = invisible. The value passed to the method = '{visible}'")
    public HomePage checkBecauseYouReadSectionVisibility(boolean visible) {
//        if (visible) becauseYouReadSection.should(exist);
//        else becauseYouReadSection.should(not(exist));
        if (visible) becauseYouReadSectionAppium.scroll(with(DOWN, 10));
        else {
            if (!fastCheckHomePageBlank()) {
                for (int i = 0; i < 10; i++)
                    becauseYouReadSectionAppium.scroll(with(DOWN, 1)).should(not(exist));
            }
        }
        return this;
    }

    @Step("Check the 'In The News' section visibility on the home page. " +
            "'True' = visible, 'false' = invisible. The value passed to the method = '{visible}'")
    public HomePage checkInTheNewsSectionVisibility(boolean visible) {
//        if (visible) inTheNewsSection.should(exist);
//        else inTheNewsSection.should(not(exist));
        if (visible) inTheNewsSectionAppium.scroll(with(DOWN, 10));
        else {
            if (!fastCheckHomePageBlank()) {
                for (int i = 0; i < 10; i++)
                    inTheNewsSectionAppium.scroll(with(DOWN, 1)).should(not(exist));
            }
        }
        return this;
    }

    @Step("Check the 'On This Day' section visibility on the home page. " +
            "'True' = visible, 'false' = invisible. The value passed to the method = '{visible}'")
    public HomePage checkOnThisDaySectionVisibility(boolean visible) {
//        if (visible) onThisDaySection.should(exist);
//        else onThisDaySection.should(not(exist));
        if (visible) onThisDaySectionAppium.scroll(with(DOWN, 10));
        else {
            if (!fastCheckHomePageBlank()) {
                for (int i = 0; i < 10; i++)
                    onThisDaySectionAppium.scroll(with(DOWN, 1)).should(not(exist));
            }
        }
        return this;
    }

    @Step("Check the 'Randomizer' section visibility on the home page. " +
            "'True' = visible, 'false' = invisible. The value passed to the method = '{visible}'")
    public HomePage checkRandomizerSectionVisibility(boolean visible) {
//        if (visible) randomizerSection.should(exist);
//        else randomizerSection.should(not(exist));
        if (visible) randomizerSectionAppium.scroll(with(DOWN, 10));
        else {
            if (!fastCheckHomePageBlank()) {
                for (int i = 0; i < 10; i++)
                    randomizerSectionAppium.scroll(with(DOWN, 1)).should(not(exist));
            }
        }
        return this;
    }

    @Step("Check the 'Today On Wikipedia' section visibility on the home page. " +
            "'True' = visible, 'false' = invisible. The value passed to the method = '{visible}'")
    public HomePage checkTodayOnWikipediaSectionVisibility(boolean visible) {
//        if (visible) todayOnWikipediaSection.should(exist);
//        else todayOnWikipediaSection.should(not(exist));
        if (visible) todayOnWikipediaSectionAppium.scroll(with(DOWN, 10));
        else {
            if (!fastCheckHomePageBlank()) {
                for (int i = 0; i < 10; i++)
                    todayOnWikipediaSectionAppium.scroll(with(DOWN, 1)).should(not(exist));
            }
        }
        return this;
    }

    @Step("Check the 'Customize' button appears and tap it")
    public void tapCustomizeButton() {
        customizeButton.click();
    }

    @Step("Scroll to the top")
    public HomePage scrollToTop() {
        searchWikipediaContainerAppium.scroll(with(UP, 20));
        return this;
    }

    @Step("Scroll to the specific section")
    public void scrollToSpecificSection(FeedToggle targetToggle) {
        //SelenideAppium.$(By.xpath(".//androidx.cardview.widget.CardView[@resource-id=\"org.wikipedia.alpha:id/search_container\"]")).scroll(with(DOWN, 20));
        switch (targetToggle) {
            case FEATURED_ARTICLE: {
                featureArticleSectionAppium.scroll(with(DOWN, 20));
                break;
            }
            case TOP_READ: {
                topReadSectionAppium.scroll(with(DOWN, 20));
                break;
            }
            case PICTURE_OF_THE_DAY: {
                pictureOfTheDaySectionAppium.scroll(with(DOWN, 20));
                break;
            }
            case BECAUSE_YOU_READ: {
                becauseYouReadSectionAppium.scroll(with(DOWN, 20));
                break;
            }
            case IN_THE_NEWS: {
                inTheNewsSectionAppium.scroll(with(DOWN, 20));
                break;
            }
            case ON_THIS_DAY: {
                onThisDaySectionAppium.scroll(with(DOWN, 20));
                break;
            }
            case RANDOMIZER: {
                randomizerSectionAppium.scroll(with(DOWN, 20));
                break;
            }
            case TODAY_ON_WIKIPEDIA: {
                todayOnWikipediaSectionAppium.scroll(with(DOWN, 20));
                break;
            }
        }
    }

    public void scrollMethod() {
            SelenideAppium.$(By.xpath(".//*[@text='Random article']")).scroll(with(DOWN, 10));
    }

    @Step("Close the 'Customize your Explore feed' announcement container " +
            "since it prevents the 'Customize' button to appear when all feeds are disabled")
    public HomePage closeCustomizeFeedAnnouncement() {
        gotItButton.click();
        return this;
    }

    @Step("Fast-check that the 'Home Page' is blank")
    public boolean fastCheckHomePageBlank() {
        return blankFeedLabel.exists();
    }

    @Step("Check whether the home page displays images")
    public void checkImages(boolean showImages) {
        if (showImages) featuredArticleImage.should(exist);
        else featuredArticleImage.shouldNot(exist);
    }
}
