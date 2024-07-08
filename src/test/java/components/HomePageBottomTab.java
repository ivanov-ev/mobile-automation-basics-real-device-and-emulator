package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class HomePageBottomTab {
    private final SelenideElement moreHamburgerButton =  $(id("org.wikipedia.alpha:id/nav_tab_more")); // inner locators are: org.wikipedia.alpha:id/navigation_bar_item_icon_container and org.wikipedia.alpha:id/navigation_bar_item_icon_view
    private final SelenideElement settingsSubItemInHamburger =  $(id("org.wikipedia.alpha:id/main_drawer_settings_container"));

    @Step("Tap 'More'")
    public HomePageBottomTab tapMore() {
        moreHamburgerButton.click();
        return this;
    }

    @Step("Enter the 'Settings' page")
    public HomePageBottomTab goToSettings() {
        settingsSubItemInHamburger.click();
        return this;
    }
}
