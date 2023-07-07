package helsi.pages.android;

import com.codeborne.selenide.SelenideElement;
import helsi.enums.SearchCategory;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static helsi.config.Configs.locator;
import static org.openqa.selenium.By.xpath;

public class SearchResultPage extends MainPage {

    @Step("Check is something found for {searchCategory.value}")
    public void analyseResult(SearchCategory searchCategory) {
    //  getShot("last page - search result");
       SelenideElement result = $(xpath(locator.searchResultSummary()));
      // log.info("text on element: "+result.text());
        resultShouldBeMoreThan(result, 0);
    }

}
