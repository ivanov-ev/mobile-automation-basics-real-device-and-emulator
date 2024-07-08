package components;

import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumCommandInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;
import types.FeedState;
import types.FeedToggle;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;
import static types.FeedToggle.FEATURED_ARTICLE;

//Todo: probably this will help to reduce the code size: https://github.com/ivanov-ev/parameterized-tests/blob/master/src/test/java/ru/example/data/Deposits.java

public class SettingsPageExploreFeed {
    private final SelenideElement navigateUp =
            $(xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
    private final SelenideElement moreOptionsMenu =
            $(xpath("//android.widget.ImageView[@content-desc=\"More options\"]")),
        showAll = $(byAttribute("text", "Show all")),
        hideAll = $(byAttribute("text", "Hide all")),
        restoreDefaultView =
                $(byAttribute("text", "Restore default view"));
    private final String toggle = "org.wikipedia.alpha:id/feed_content_type_checkbox",
            dragHandle = "org.wikipedia.alpha:id/feed_content_type_drag_handle";
    private final SelenideElement featureArticleItem =
            $(byAttribute("text", "Featured article")).parent().parent(),
            featureArticleDragHandle = featureArticleItem.$(id(dragHandle)), //todo fix it and similar drag handlers
            featureArticleToggle = $(xpath("//android.widget.TextView[@resource-id=" +
                    "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Featured article\"]/../.." +
                    "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement topReadItem =
            $(byAttribute("text", "Top read")).parent().parent(),
            topReadDragHandle = topReadItem.$(id(toggle)),
            topReadToggle = $(xpath("//android.widget.TextView[@resource-id=" +
                    "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Top read\"]/../.." +
                    "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement pictureOfTheDayItem =
            $(byAttribute("text", "Picture of the day")).parent().parent(),
            pictureOfTheDayDragHandle = pictureOfTheDayItem.$(id(toggle)),
            pictureOfTheDayToggle = $(xpath("//android.widget.TextView[@resource-id=" +
            "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Picture of the day\"]/../.." +
            "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement becauseYouReadItem =
            $(byAttribute("text", "Because you read")).parent().parent(),
            becauseYouReadDragHandle = becauseYouReadItem.$(id(toggle)),
            becauseYouReadToggle = $(xpath("//android.widget.TextView[@resource-id=" +
                    "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Because you read\"]/../.." +
                    "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement inTheNewsItem =
            $(byAttribute("text", "In the news")).parent().parent(),
            inTheNewsDragHandle = inTheNewsItem.$(id(toggle)),
            inTheNewsToggle = $(xpath("//android.widget.TextView[@resource-id=" +
                    "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"In the news\"]/../.." +
                    "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement onThisDayItem =
            $(byAttribute("text", "On this day")).parent().parent(),
            onThisDayDragHandle = onThisDayItem.$(id(toggle)),
            onThisDayToggle = $(xpath("//android.widget.TextView[@resource-id=" +
                    "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"On this day\"]/../.." +
                    "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement randomizerItem =
            $(byAttribute("text", "Randomizer")).parent().parent(),
            randomizerDragHandle = randomizerItem.$(id(toggle)),
            randomizerToggle = $(xpath("//android.widget.TextView[@resource-id=" +
                    "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Randomizer\"]/../.." +
                    "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));
    private final SelenideElement todayOnWikipediaItem =
            $(byAttribute("text", "Today on Wikipedia")).parent().parent(),
            todayOnWikipediaDragHandle = todayOnWikipediaItem.$(id(toggle)),
            todayOnWikipediaToggle = $(xpath("//android.widget.TextView[@resource-id=" +
                    "\"org.wikipedia.alpha:id/feed_content_type_title\" and @text=\"Today on Wikipedia\"]/../.." +
                    "/android.widget.Switch[@resource-id=\"org.wikipedia.alpha:id/feed_content_type_checkbox\"]"));

    @Step("Switch the toggle in the feed settings")
    public SettingsPageExploreFeed switchToggle(FeedToggle targetToggle, boolean targetState) {
        boolean currentState;
        switch (targetToggle) {
            case FEATURED_ARTICLE: {
                currentState = Boolean.parseBoolean(featureArticleToggle.getAttribute("checked"));
                if(currentState != targetState) featureArticleToggle.click();
                break;
            }
            case TOP_READ: {
                currentState = Boolean.parseBoolean(topReadToggle.getAttribute("checked"));
                if(currentState != targetState) topReadToggle.click();
                break;
            }
            case PICTURE_OF_THE_DAY: {
                currentState = Boolean.parseBoolean(pictureOfTheDayToggle.getAttribute("checked"));
                if(currentState != targetState) pictureOfTheDayToggle.click();
                break;
            }
            case BECAUSE_YOU_READ: {
                currentState = Boolean.parseBoolean(becauseYouReadToggle.getAttribute("checked"));
                if(currentState != targetState) becauseYouReadToggle.click();
                break;
            }
            case IN_THE_NEWS: {
                currentState = Boolean.parseBoolean(inTheNewsToggle.getAttribute("checked"));
                if(currentState != targetState) inTheNewsToggle.click();
                break;
            }
            case ON_THIS_DAY: {
                currentState = Boolean.parseBoolean(onThisDayToggle.getAttribute("checked"));
                if(currentState != targetState) onThisDayToggle.click();
                break;
            }
            case RANDOMIZER: {
                currentState = Boolean.parseBoolean(randomizerToggle.getAttribute("checked"));
                if(currentState != targetState) randomizerToggle.click();
                break;
            }
            case TODAY_ON_WIKIPEDIA: {
                currentState = Boolean.parseBoolean(todayOnWikipediaToggle.getAttribute("checked"));
                if(currentState != targetState) todayOnWikipediaToggle.click();
                break;
            }
        }
        return this;
    }

    @Step("Drag and drop")
    public SettingsPageExploreFeed dragAndDrop(FeedToggle toggleToMove, FeedToggle targetToggle) {
        // https://stackoverflow.com/questions/29298096/how-to-tap-and-hold-long-press-using-appium-for-android
        //Todo
        /*
        Click and hold the item to move
        Determine whether the target location is below or above
        If it is below, then drag a bit lower than the center of the target position (in absolute number of pixels) and pull
        If it is above, then do the opposite
         */

        //If this does not work, then I should move to one more position above or below.!!!!

        //actions().moveToElement($(sourceElement)).clickAndHold().moveByOffset(offsetX, offsetY).release().perform();

        SelenideElement dragHandle = null;
        SelenideElement targetPosition = null;
        switch (toggleToMove) {
            case FEATURED_ARTICLE: {
                dragHandle = featureArticleDragHandle;
                break;
            }
            case TOP_READ: {
                dragHandle = topReadDragHandle;
                break;
            }
            case PICTURE_OF_THE_DAY: {
                dragHandle = pictureOfTheDayDragHandle;
                break;
            }
            case BECAUSE_YOU_READ: {
                dragHandle = becauseYouReadDragHandle;
                break;
            }
            case IN_THE_NEWS: {
                dragHandle = inTheNewsDragHandle;
                break;
            }
            case ON_THIS_DAY: {
                dragHandle = onThisDayDragHandle;
                break;
            }
            case RANDOMIZER: {
                dragHandle = randomizerDragHandle;
                break;
            }
            case TODAY_ON_WIKIPEDIA: {
                dragHandle = todayOnWikipediaDragHandle;
                break;
            }
        }
        switch (targetToggle) {
            case FEATURED_ARTICLE: {
                targetPosition = featureArticleDragHandle;
                break;
            }
            case TOP_READ: {
                targetPosition = topReadDragHandle;
                break;
            }
            case PICTURE_OF_THE_DAY: {
                targetPosition = pictureOfTheDayDragHandle;
                break;
            }
            case BECAUSE_YOU_READ: {
                targetPosition = becauseYouReadDragHandle;
                break;
            }
            case IN_THE_NEWS: {
                targetPosition = inTheNewsDragHandle;
                break;
            }
            case ON_THIS_DAY: {
                targetPosition = onThisDayDragHandle;
                break;
            }
            case RANDOMIZER: {
                targetPosition = randomizerDragHandle;
                break;
            }
            case TODAY_ON_WIKIPEDIA: {
                targetPosition = todayOnWikipediaDragHandle;
                break;
            }
        }
        dragHandle.dragAndDropTo(targetPosition);
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
