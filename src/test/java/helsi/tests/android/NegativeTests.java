package helsi.tests.android;

import helsi.annotations.JiraIssue;
import helsi.annotations.JiraIssues;
import helsi.annotations.Layer;
import helsi.enums.SearchCategory;
import helsi.tests.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static helsi.enums.SearchCategory.DRUG;

@Tag("android")

@Feature("Mobile tests")
@Story("Android platform")
@Tags({@Tag("mobile"), @Tag("live")})
@DisplayName("Negative test for reflect allure possibilities.")
@Owner("xt4k")
@Layer("Mobile")
@JiraIssues({@JiraIssue("AUTO-001")})


public class NegativeTests extends TestBase {
    @Test
    @Owner("HELSI_app_demo")
    @DisplayName("UnSuccessful search for drug (not found)")
    void unHappyPathDrugSearch() {
        mainPage
                .tapToSearchSelectionPopup()
                .selectCategory(DRUG);
        searchPage
                .setSearchString("Kaliberda")
                .analyseResult(DRUG);
    }



}
