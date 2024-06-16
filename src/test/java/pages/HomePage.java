package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class HomePage {
    private final SelenideElement searchContainer = $(id("org.wikipedia.alpha:id/search_container"));

    public void checkMainPageIsOpen () {
        searchContainer.should(Condition.exist);
    }
}
