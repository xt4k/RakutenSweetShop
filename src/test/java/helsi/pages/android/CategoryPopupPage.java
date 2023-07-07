package helsi.pages.android;


import helsi.enums.SearchCategory;
import helsi.pages.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static helsi.config.Configs.locator;
import static org.openqa.selenium.By.xpath;

public class CategoryPopupPage extends BasePage {

    @Step("Select search category: '{searchCategory.value}'")
    public MainPage selectCategory(SearchCategory searchCategory) {

        String categoryButtonXpath = switch (searchCategory) {
            case DRUG -> locator.popupCategoryDrug();
            case DOCTOR_NAME -> locator.popupCategoryDoctorName();
            default -> "x3";
        };

        $(xpath(categoryButtonXpath)).click();
        return new MainPage();
    }
}
