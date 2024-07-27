package components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.qameta.allure.Step;
import types.FeedState;
import types.FeedToggle;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.AppiumScrollOptions.with;
import static com.codeborne.selenide.appium.ScrollDirection.DOWN;
import static com.codeborne.selenide.appium.ScrollDirection.UP;
import static org.openqa.selenium.By.xpath;

public class SettingsPageExploreFeed {
    private final SelenideElement navigateUp =
            $(xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
    private final SelenideElement moreOptionsMenu =
            $(xpath("//android.widget.ImageView[@content-desc=\"More options\"]")),
            showAll = $(byAttribute("text", "Show all")),
            hideAll = $(byAttribute("text", "Hide all")),
            restoreDefaultView = $(byAttribute("text", "Restore default view"));
    private final SelenideElement featureArticleToggle = $(xpath("//android.widget.TextView[@resource-id=" +
            "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Featured article\"]/../.." +
            "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement topReadToggle = $(xpath("//android.widget.TextView[@resource-id=" +
            "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Top read\"]/../.." +
            "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement pictureOfTheDayToggle = $(xpath("//android.widget.TextView[@resource-id=" +
            "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Picture of the day\"]/../.." +
            "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement becauseYouReadToggle = $(xpath("//android.widget.TextView[@resource-id=" +
            "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Because you read\"]/../.." +
            "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement inTheNewsToggle = $(xpath("//android.widget.TextView[@resource-id=" +
            "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"In the news\"]/../.." +
            "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement onThisDayToggle = $(xpath("//android.widget.TextView[@resource-id=" +
            "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"On this day\"]/../.." +
            "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement randomizerToggle = $(xpath("//android.widget.TextView[@resource-id=" +
            "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Randomizer\"]/../.." +
            "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideAppiumElement randomizerToggleAppium = SelenideAppium
            .$(xpath("//android.widget.TextView[@resource-id=" +
                    "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Randomizer\"]/../.." +
                    "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement todayOnWikipediaToggle = $(xpath("//android.widget.TextView[@resource-id=" +
            "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Today on Wikipedia\"]/../.." +
            "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideAppiumElement todayOnWikipediaToggleAppium = SelenideAppium
            .$(xpath("//android.widget.TextView[@resource-id=" +
                    "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Today on Wikipedia\"]/../.." +
                    "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));

    @Step("Switch the toggle in the feed settings")
    public SettingsPageExploreFeed switchToggle(FeedToggle targetToggle, boolean targetState) {
        boolean currentState;
        switch (targetToggle) {
            case FEATURED_ARTICLE: {
                currentState = Boolean.parseBoolean(featureArticleToggle.getAttribute("checked"));
                if (currentState != targetState) featureArticleToggle.click();
                break;
            }
            case TOP_READ: {
                currentState = Boolean.parseBoolean(topReadToggle.getAttribute("checked"));
                if (currentState != targetState) topReadToggle.click();
                break;
            }
            case PICTURE_OF_THE_DAY: {
                currentState = Boolean.parseBoolean(pictureOfTheDayToggle.getAttribute("checked"));
                if (currentState != targetState) pictureOfTheDayToggle.click();
                break;
            }
            case BECAUSE_YOU_READ: {
                currentState = Boolean.parseBoolean(becauseYouReadToggle.getAttribute("checked"));
                if (currentState != targetState) becauseYouReadToggle.click();
                break;
            }
            case IN_THE_NEWS: {
                currentState = Boolean.parseBoolean(inTheNewsToggle.getAttribute("checked"));
                if (currentState != targetState) inTheNewsToggle.click();
                break;
            }
            case ON_THIS_DAY: {
                currentState = Boolean.parseBoolean(onThisDayToggle.getAttribute("checked"));
                if (currentState != targetState) onThisDayToggle.click();
                break;
            }
            case RANDOMIZER: {
                //This code is for small screens where some toggles do not fit the screen height. This code was not
                //added to the above cases to reduce the code size because it is not needed right now.
                if (!randomizerToggle.exists()) {
                    randomizerToggleAppium.scroll(with(DOWN, 1));
                }
                if (!todayOnWikipediaToggle.exists()) {
                    randomizerToggleAppium.scroll(with(UP, 1));
                }
                currentState = Boolean.parseBoolean(randomizerToggle.getAttribute("checked"));
                if (currentState != targetState) randomizerToggle.click();
                break;
            }
            case TODAY_ON_WIKIPEDIA: {
                //This code is for small screens where some toggles do not fit the screen height. This code was not
                //added to the above cases to reduce the code size because it is not needed right now.
                if (!todayOnWikipediaToggle.exists()) {
                    todayOnWikipediaToggleAppium.scroll(with(DOWN, 1));
                }
                if (!todayOnWikipediaToggle.exists()) {
                    todayOnWikipediaToggleAppium.scroll(with(UP, 1));
                }
                currentState = Boolean.parseBoolean(todayOnWikipediaToggle.getAttribute("checked"));
                if (currentState != targetState) todayOnWikipediaToggle.click();
                break;
            }
        }
        return this;
    }

    @Step("Change the feed state through the hamburger menu")
    public SettingsPageExploreFeed changeFeedStateThroughHamburger(FeedState targetState) {
        moreOptionsMenu.click();
        switch (targetState) {
            case SHOW_ALL: {
                showAll.click();
                break;
            }
            case HIDE_ALL: {
                hideAll.click();
                break;
            }
            case RESTORE: {
                restoreDefaultView.click();
                break;
            }
        }
        return this;
    }

    @Step("Exit 'Customize the feed'")
    public SettingsPageExploreFeed exitCustomizeFeed() {
        navigateUp.click();
        return this;
    }
}
