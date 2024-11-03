package autotests.tests.login;

import autotests.annotations.JiraIssue;
import autotests.annotations.JiraIssues;
import autotests.annotations.Layer;
import autotests.annotations.TM4J;
import autotests.po.AccountPage;
import autotests.tests.TestBase;
import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Feature("Web tests")
@Story("Login page tests")
@Tags({@Tag("web"), @Tag("Sweet_Shop")})
@Owner("other guy")
@JiraIssues({@JiraIssue("AUTO-865")})
@DisplayName("Test set for Login page.")
@Layer("UI")
@Issue("5781")
@Tag("login")
public class LoginTests extends TestBase {

    @Test
    @JiraIssues({@JiraIssue("AUTO-7634")})
    @TM4J("6537")
    @Tag("positive")
    @DisplayName("Testcase 5. Positive Login test.")
    @Description("Testcase 5. Positive Login test.")
    void loginHappyPath() {

        AccountPage accountPage = po.openHome()
                .goToLogin()
                .setEmailAddress("e@ma.il")
                .setPassword("123")
                .logIn();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(accountPage.getWelcomeMessage())
                    .as("Welcome message should be definitely welcome!")
                    .containsIgnoringCase("welcome back");
            softly.assertThat(accountPage.getAccountPageHeader())
                    .as("Header for Account page should point that this is account page")
                    .containsIgnoringCase("account");
        });
    }


    @Test
    @JiraIssues({@JiraIssue("AUTO-9513")})
    @TM4J("8521")
    @Tag("failed")
    @DisplayName("Testcase 6. Negative Login test. FAILED IN PURPOSE!")
    @Description("Testcase 6. Negative Login test. FAILED IN PURPOSE!")
    void loginUnHappyPath() {
        AccountPage accountPage = po.openHome()
                .goToLogin()
                .setEmailAddress("e")
                .setPassword("123")
                .logIn();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(accountPage.getWelcomeMessage())
                    .as("This is test that failed in purpose. We are not expect this message here!")
                    .containsIgnoringCase("welcome back");
            softly.assertThat(accountPage.getAccountPageHeader())
                    .as("This is test that failed in purpose. We are not expect this message here!")
                    .containsIgnoringCase("account");
        });
    }
}
