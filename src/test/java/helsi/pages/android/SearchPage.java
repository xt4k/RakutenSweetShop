package helsi.pages.android;

import helsi.pages.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static helsi.config.Configs.locator;
import static org.openqa.selenium.By.xpath;

public class SearchPage extends BasePage {
    @Step("Searching: '{searchString}'")
    public SearchResultPage setSearchString(String searchString) {
        //getShot("Searching_"+1);
        $(xpath(locator.mainpageSearch())).click();
     //   getShot("Searching_"+2);
        $(xpath(locator.searchingField())).sendKeys(searchString);
     //   getShot("Searching_"+3);
        $(xpath(locator.drugFind())).click();
    //    getShot("Searching_"+4);
        return new SearchResultPage();
    }
}
