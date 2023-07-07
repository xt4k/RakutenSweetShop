package helsi.pages.android;

import helsi.enums.SearchCategory;
import helsi.pages.BasePage;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static helsi.config.Configs.locator;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class MainPage extends BasePage {

    @Step("Tap to open search category popup")
    public CategoryPopupPage tapToSearchSelectionPopup() {
        $(xpath(locator.mainPageCategorySearch())).click();
        return new CategoryPopupPage();
    }

    @Step("Search '{searchCriteriaType.value}' for {searchString}'.")
    public SearchResultPage mainPageSearch(String searchString, SearchCategory searchCategory) {
        $(className(locator.searchField())).click();
        $(className(locator.searchField())).sendKeys(searchString);
        back();

        String searchButtonXpath = switch (searchCategory) {
            case DRUG -> locator.searchFind();
            case DOCTOR_NAME -> locator.searchDoctorByName();
            default -> "x3";
        };
        $(xpath(searchButtonXpath)).click();
        return new SearchResultPage();
    }
}
