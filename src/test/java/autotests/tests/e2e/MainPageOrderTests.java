package autotests.tests.e2e;

import autotests.annotations.JiraIssue;
import autotests.annotations.JiraIssues;
import autotests.annotations.Layer;
import autotests.annotations.TM4J;
import autotests.po.BasketPage;
import autotests.pojo.BasketOrder;
import autotests.tests.TestBase;
import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Web tests")
@Story("E2E functionality")
@Tags({@Tag("web"), @Tag("Sweet_Shop")})
@Owner("xt4k")
@Tag("basket")
@JiraIssues({@JiraIssue("AUTO-1287")})
@DisplayName("Test set for Sweet Shop Main Page.")
@Layer("UI")
@Issue("7451")
public class MainPageOrderTests extends TestBase {


    @Test
    @JiraIssues({@JiraIssue("AUTO-7536")})
    @TM4J("2185")
    @DisplayName("Testcase 1. Check that all the selected items are present in basket.")
    @Description("Testcase 1. Check that all the selected items are present in basket.")
    void checkPresenceSelectedItemInBasket() {
        String messageDraft = "{} numbers expected `{}` should be equal to actual:`{}`.";
        BasketOrder bo = BasketOrder.builder().build();
        bo.setSherbertDisc(1)
                .setBonBon(4)
                .setChocolateCup(2)
                .setSherbertStraw(3);

        BasketPage basketPage = po.openHome()
                .addChocolateCupToBasket(bo.getChocolateCup().getNumber())
                .addSherbertDiscToBasket(bo.getSherbertDisc().getNumber())
                .addSherbertStrawBasket(bo.getSherbertStraw().getNumber())
                .addBonBonToBasket(bo.getBonBon().getNumber())
                .goToBasket();

        SoftAssertions.assertSoftly(softly -> {
            System.out.println();
            String sherbetDiscsNum = basketPage.getSherbetDiscsNumber();
            String chocolateCupsNum = basketPage.getChocolateCupsNumber();
            String sherbertStrawsNum = basketPage.getSherbertStrawsNumber();
            String bonBonsNum = basketPage.getBonBonsNumber();

            softly.assertThat(basketPage.getSherbetDiscsNumber())
                    .as(messageDraft, bo.getSherbertDisc().getNumber(), sherbetDiscsNum)
                    .isEqualTo(valueOf(sherbetDiscsNum));
            System.out.println();
            softly.assertThat(chocolateCupsNum)
                    .as(messageDraft, bo.getSherbertDisc().getNumber(), chocolateCupsNum)
                    .isEqualTo(valueOf(bo.getChocolateCup().getNumber()));

            softly.assertThat(sherbertStrawsNum)
                    .as(messageDraft, bo.getSherbertStraw().getNumber(), sherbertStrawsNum)
                    .isEqualTo(valueOf(bo.getSherbertStraw().getNumber()));

            softly.assertThat(bonBonsNum)
                    .as(messageDraft, bo.getBonBon().getNumber(), bonBonsNum)
                    .isEqualTo(valueOf(bo.getBonBon().getNumber()));

            softly.assertThat(bonBonsNum)
                    .as(messageDraft, bo.getBonBon().getNumber(), bonBonsNum)
                    .isEqualTo(valueOf(bo.getBonBon().getNumber()));

        });
    }

    @Test
    @JiraIssues({@JiraIssue("AUTO-6723")})
    @TM4J("9247")
    @DisplayName("Testcase 2. Test the basket Total sum matches the price of individual items based on quantity and currency.")
    @Description("Testcase 2. Test the basket Total sum matches the price of individual items based on quantity and currency.")
    void checkBasketTotalPrice() {
        BasketOrder bo = BasketOrder.builder().build();
        bo.setSherbertDisc(3)
                .setBonBon(1)
                .setChocolateCup(2)
                .setSherbertStraw(4);
        Double totalSum = bo.getTotalSum();

        BasketPage basketPage = po.openHome()
                .addChocolateCupToBasket(bo.getChocolateCup().getNumber())
                .addSherbertDiscToBasket(bo.getSherbertDisc().getNumber())
                .addSherbertStrawBasket(bo.getSherbertStraw().getNumber())
                .addBonBonToBasket(bo.getBonBon().getNumber())
                .goToBasket();

        SoftAssertions.assertSoftly(softly -> {
            Double actualSum = Double.parseDouble(basketPage.getTotalSumValue());
            String actualCurrency = basketPage.getBasketCurrency();

            softly.assertThat(actualSum)
                    .as("Total sum expected `{}` should be equal to actual:`{}`.", totalSum, actualSum)
                    .isEqualTo(totalSum);
            softly.assertThat(actualCurrency)
                    .as("Basket currency expected `{}` should be equal to actual:`{}`.", bo.getCurrency(), actualCurrency)
                    .contains(bo.getCurrency());
        });
    }

    @Test
    @JiraIssues({@JiraIssue("AUTO-9565")})
    @TM4J("7461")
    @DisplayName("Testcase 3. Change the delivery type to 'Standard Shipping' and verify the total price.")
    @Description("Testcase 3. Change the delivery type to 'Standard Shipping' and verify the total price.")
    void checkDeliveryTypeChanging() {
        po.openHome()
                .addChocolateCupToBasket(1)
                .goToBasket()
                .checkStandardShipping();

        String totalWithStandard = new BasketPage().getTotalSumValue();
        Double totalSum = new BasketOrder().getChocolateCup().getPrice();
        assertThat(totalWithStandard)
                .as("Total sum expected `{}` should be equal to actual:`{}`.", totalSum, totalWithStandard)
                .isNotEqualTo(String.valueOf(totalSum));
    }
}
