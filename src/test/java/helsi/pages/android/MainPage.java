package helsi.pages.android;

import helsi.pages.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static helsi.config.Configs.locator;
import static org.openqa.selenium.By.xpath;

public class MainPage extends BasePage {

    @Step("Tap to open search category popup")
    public CategoryPopupPage tapToSearchSelectionPopup() {
        $(xpath(locator.mainPageCategorySearch())).click();
        return new CategoryPopupPage();
    }

    @Step("Search '{searchCriteriaType}' for {searchString}'.")
    public SearchResultPage mainPageSearch(String searchString, String searchCriteriaType) {
        $(xpath(locator.mainpageSearch())).click();
        $(xpath(locator.searchField())).sendKeys(searchString);
        back();

        String searchButtonXpath = switch (searchCriteriaType) {
            case "drug_name" -> locator.searchFind();
            case "doctor_name" -> locator.searchDoctorByName();
            default -> "x3";
        };
        $(xpath(searchButtonXpath)).click();
        return new SearchResultPage();
    }
}
