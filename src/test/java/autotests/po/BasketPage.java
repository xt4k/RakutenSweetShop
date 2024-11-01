package autotests.po;

import autotests.pojo.BillingForm;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;


public class BasketPage extends BasePage {

    BillingFormWidget billingFormWidget = new BillingFormWidget();
    String locatorPattern = "//h6[text()='%s']/following-sibling::small";
    SelenideElement itemChocolateCup = $x(format(locatorPattern, "Chocolate Cups"));
    SelenideElement itemSherbertDisc = $x(format(locatorPattern, "Sherbet Discs"));
    SelenideElement itemSherbertStraw = $x(format(locatorPattern, "Sherbert Straws"));
    SelenideElement itemBonBon = $x(format(locatorPattern, "Strawberry Bon Bons"));
    SelenideElement totalSumValue = $("#basketItems strong");
    SelenideElement basketCurrency = $("#basketItems span:not([class])");
    SelenideElement chkBoxStandardShipping = $("#exampleRadios2");


    @Step("Get `Chocolate Cups` number")
    public String getChocolateCupsNumber() {
        return getItemNumber(itemChocolateCup);
    }

    @Step("Get `Sherbet Discs` number")
    public String getSherbetDiscsNumber() {
        return getItemNumber(itemSherbertDisc);
    }


    @Step("Get `Sherbert Straws` number")
    public String getSherbertStrawsNumber() {
        return getItemNumber(itemSherbertStraw);
    }

    @Step("Get `Strawberry Bon Bons` number")
    public String getBonBonsNumber() {
        return getItemNumber(itemBonBon);
    }


    private String getItemNumber(SelenideElement se) {
        String number = se.getText();
        return number.substring(2);
    }

    @Step("Get Basket `Total` value")
    public String getTotalSumValue() {
        return totalSumValue.getText().substring(1);
    }

    @Step("Get Basket `Total` currency abbreviation")
    public String getBasketCurrency() {
        return basketCurrency.getText();
    }

    @Step("Check `Standard Shipping` delivery")
    public BasketPage checkStandardShipping() {
        chkBoxStandardShipping.parent().click();
        return new BasketPage();
    }

    public BasketPage fillBillingForm(BillingForm billingForm) {
        billingFormWidget.fillAndCheckout(billingForm);
        return this;
    }
}
