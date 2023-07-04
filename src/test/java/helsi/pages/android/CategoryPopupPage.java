package helsi.pages.android;


import helsi.pages.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static helsi.config.Configs.locator;
import static org.openqa.selenium.By.xpath;

public class CategoryPopupPage extends BasePage {

    @Step("Select search category: '{searchCategory}'")
    public MainPage selectCategory(String searchCategory) {

        String categoryButtonXpath = switch (searchCategory) {
            case "drug_name" -> locator.popupCategoryDrug();
            case "doctor_name" -> locator.popupCategoryDoctorName();
            default -> "x3";
        };

        $(xpath(categoryButtonXpath)).click();
        return new MainPage();
    }
}
