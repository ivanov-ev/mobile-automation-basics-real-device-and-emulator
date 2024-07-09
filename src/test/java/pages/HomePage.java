package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.qameta.allure.Step;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import types.FeedToggle;
import types.Theme;

import static com.codeborne.selenide.appium.AppiumScrollOptions.with;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.appium.ScrollDirection.DOWN;
import static com.codeborne.selenide.appium.ScrollDirection.UP;
import static io.appium.java_client.AppiumBy.id;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.xpath;

public class HomePage {
    private final SelenideElement searchWikipediaContainer =
            $(id("org.wikipedia.alpha:id/search_container"));
    private final SelenideAppiumElement searchWikipediaContainerAppium = SelenideAppium.
            $(id("org.wikipedia.alpha:id/search_container"));
    private final SelenideAppiumElement featureArticleSectionAppium = SelenideAppium.
            $(byAttribute("text", "Featured article")),
            topReadSectionAppium = SelenideAppium.
                    $(byAttribute("text", "Top read")),
            pictureOfTheDaySectionAppium = SelenideAppium.
                    $(byAttribute("text", "Picture of the day")),
            becauseYouReadSectionAppium = SelenideAppium.
                    $(byAttribute("text", "Because you read")),
            inTheNewsSectionAppium = SelenideAppium.
                    $(byAttribute("text", "In the news")),
            onThisDaySectionAppium = SelenideAppium.
                    $(byAttribute("text", "On this day")),
            randomizerSectionAppium = SelenideAppium.
                    $(byAttribute("text", "Random article")),
            todayOnWikipediaSectionAppium = SelenideAppium.
                    $(byAttribute("text", "Today on Wikipedia"));
    private final SelenideElement blankFeedLabel =
                    $(xpath("//android.widget.TextView[@text=\"There's nothing on your Explore feed\"]")),
            customizeButton =
                    $(xpath("//android.widget.Button[@resource-id=\"org.wikipedia.alpha:id/customize_button\"]"));
    private final SelenideElement gotItButton = $(id("org.wikipedia.alpha:id/view_announcement_action_negative"));
    private final SelenideElement featuredArticleImage =
            $(xpath("//android.widget.ImageView[@resource-id=\"org.wikipedia.alpha:id/articleImage\"]"));

    public void checkMainPageIsOpen() {
        searchWikipediaContainer.should(exist);
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

    @Step("Check the 'Feature Article' section visibility on the home page. " +
            "'True' = visible, 'false' = invisible. The value passed to the method = '{visible}'")
    public HomePage checkFeatureArticleSectionVisibility(boolean visible) {
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
        if (visible) pictureOfTheDaySectionAppium.scroll(with(DOWN, 10));
        else {
            if (!fastCheckHomePageBlank()) {
                for (int i = 0; i < 10; i++)
                    pictureOfTheDaySectionAppium.scroll(with(DOWN, 1)).should(not(exist));
            }
        }
        return this;
    }

    //TODO: FUTURE_FIX the method is currently not used because the 'Because You Read' section never appears in the app
    @Step("Check the 'Because You Read' section visibility on the home page. " +
            "'True' = visible, 'false' = invisible. The value passed to the method = '{visible}'")
    public HomePage checkBecauseYouReadSectionVisibility(boolean visible) {
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
        if (visible) todayOnWikipediaSectionAppium.scroll(with(DOWN, 10));
        else {
            if (!fastCheckHomePageBlank()) {
                for (int i = 0; i < 10; i++)
                    todayOnWikipediaSectionAppium.scroll(with(DOWN, 1)).should(not(exist));
            }
        }
        return this;
    }

    @Step("Scroll to the top")
    public HomePage scrollToTop() {
        searchWikipediaContainerAppium.scroll(with(UP, 20));
        return this;
    }

    @Step("Check the 'Customize' button appears and tap it")
    public void tapCustomizeButton() {
        customizeButton.click();
    }

    @Step("Check whether the home page displays images")
    public void checkImages(boolean showImages) {
        if (showImages) featuredArticleImage.should(exist);
        else featuredArticleImage.shouldNot(exist);
    }

    @Step("Check the selected theme color")
    public void checkSelectedThemeColor(Theme theme) throws IOException {
        File file = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
        BufferedImage bufferedImage = ImageIO.read(file);
        int pixelColor = bufferedImage.getRGB(245,75);
        int red = (pixelColor & 0x00ff0000) >> 16;
        int green = (pixelColor & 0x0000ff00) >> 8;
        int blue = pixelColor & 0x000000ff;
        switch(theme) {
            case LIGHT: {
                Assertions.assertEquals(255, red);
                Assertions.assertEquals(255, green);
                Assertions.assertEquals(255, blue);
                break;
            }
            case SEPIA: {
                Assertions.assertEquals(248, red);
                Assertions.assertEquals(241, green);
                Assertions.assertEquals(227, blue);
                break;
            }
            case DARK: {
                //This assertion differs from the others to get around the buggy behavior of the Android emulator
                //or the UiAutomator2 engine, which resulted in a bit different gray color at every run
                Integer[] expectedTitles = {31, 32, 33, 34, 35};
                List<Integer> expectedTitlesList = Arrays.asList(expectedTitles);
                assertTrue(expectedTitlesList.contains((red)));
                assertTrue(expectedTitlesList.contains((green)));
                assertTrue(expectedTitlesList.contains((blue)));
                break;
            }
            case BLACK: {
                Assertions.assertEquals(0, red);
                Assertions.assertEquals(0, green);
                Assertions.assertEquals(0, blue);
                break;
            }
        }
    }
}
