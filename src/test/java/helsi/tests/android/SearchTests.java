package helsi.tests.android;

import helsi.annotations.JiraIssue;
import helsi.annotations.JiraIssues;
import helsi.annotations.Layer;
import helsi.tests.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static helsi.enums.SearchCategory.DOCTOR_NAME;
import static helsi.enums.SearchCategory.DRUG;

@Tag("android")

@Feature("Mobile tests")
@Story("Android platform")
@Tags({@Tag("mobile"), @Tag("live")})
@DisplayName("Testset for 'live' mobile on Android platform tests.")
@Owner("xt4k")
@Layer("Mobile")
@JiraIssues({@JiraIssue("AUTO-001")})
@Issue("555")

public class SearchTests extends TestBase {
    @Test
    @Owner("HELSI_app_demo")
    @DisplayName("Successful search for drug")
    void happyPathDrugSearch() {
        mainPage
                .tapToSearchSelectionPopup()
                .selectCategory(DRUG);
        searchPage
                .setSearchString("Kali")
                .analyseResult(DRUG);
    }

    @Test
    @Owner("HELSI_app_demo")
    @DisplayName("Successful search by doctor last name")
    void happyPathDoctorLastnameSearch() {
        mainPage
                .tapToSearchSelectionPopup()
                .selectCategory(DOCTOR_NAME)
                .mainPageSearch("Петренко", DOCTOR_NAME)
                .analyseResult(DOCTOR_NAME);
    }



}
