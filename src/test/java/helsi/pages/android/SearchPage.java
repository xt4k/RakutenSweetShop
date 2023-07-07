package helsi.pages.android;

import helsi.pages.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static helsi.config.Configs.locator;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class SearchPage extends BasePage {
    @Step("Searching: '{searchString}'")
    public SearchResultPage setSearchString(String searchString) {
        $(className(locator.searchField())).click();
        $(className(locator.searchField())).sendKeys(searchString);
        $(xpath(locator.drugFind())).click();
    //    getShot("Searching_"+4);
        return new SearchResultPage();
    }
}
