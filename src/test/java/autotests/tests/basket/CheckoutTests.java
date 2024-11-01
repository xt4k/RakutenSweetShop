package autotests.tests.basket;

import autotests.annotations.JiraIssue;
import autotests.annotations.JiraIssues;
import autotests.annotations.Layer;
import autotests.annotations.TM4J;
import autotests.po.BasketPage;
import autotests.pojo.BasketOrder;
import autotests.pojo.BillingForm;
import autotests.tests.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Web tests")
@Story("Checkout page tests")
@Tags({@Tag("web"), @Tag("Sweet_Shop")})
@Owner("xt4k")
@JiraIssues({@JiraIssue("AUTO-186")})
@DisplayName("Test set for checkout page.")
@Layer("UI")
@Issue("6978")
@Tag("checkout")
public class CheckoutTests extends TestBase {

    @Test
    @JiraIssues({@JiraIssue("AUTO-793")})
    @TM4J("1247")
    @DisplayName("Testcase 4. Verify checkout after filling form.")
    @Description("Testcase 4. Verify checkout after filling form.")
    void checkFillingFormThenCheckout() {
        BasketOrder bo = BasketOrder.builder().build();
        bo.setSherbertDisc(1);
        Double totalSum = bo.getSherbertDisc().getPrice();

        BasketPage basketPage = po.openHome()
                .addSherbertDiscToBasket(bo.getSherbertDisc().getNumber())
                .goToBasket()
                .checkStandardShipping()
                .fillBillingForm(new BillingForm());

        assertThat(Double.parseDouble(new BasketPage().getTotalSumValue()))
                .as("Total sum expected `{}` should be equal to actual:`{}`.", totalSum, basketPage.getTotalSumValue())
                .isEqualTo(totalSum);
    }
}
