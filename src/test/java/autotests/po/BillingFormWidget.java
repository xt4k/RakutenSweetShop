package autotests.po;

import autotests.helpers.AttachmentsHelper;
import autotests.pojo.BillingForm;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class BillingFormWidget extends BasePage {

    SelenideElement formContainer = $("form.needs-validation");

    SelenideElement btnCheckout = formContainer.$("form.needs-validation button");
    SelenideElement inputCvv = formContainer.$("#cc-cvv");
    SelenideElement inputExpiration = formContainer.$("#cc-expiration");

    SelenideElement inputCreditCardNumber = formContainer.$("#cc-number");
    SelenideElement inputCreditCardName = formContainer.$("#cc-name");
    SelenideElement inputZip = formContainer.$("#zip");
    SelenideElement inputCity = formContainer.$("#city");
    SelenideElement inputCountry = formContainer.$("#country");
    SelenideElement inputAddress = formContainer.$("#address");

    SelenideElement inputEmail = formContainer.$("#email");
    SelenideElement inputLastName = $x("//label[@for='firstName']/following-sibling::input");
    SelenideElement inputFirstName = $x("//label[@for='lastName']/following-sibling::input");


    @Step("Fill billing form")
    public void fillAndCheckout(BillingForm bf) {
        inputFirstName.setValue(bf.getFirstName());
        inputLastName.setValue(bf.getLastName());

        inputEmail.setValue(bf.getEmail());
        inputAddress.setValue(bf.getAddress());

        inputCountry.click();
        inputCountry.sendKeys(bf.getCountryFirstLetter());

        inputCity.click();
        inputCity.sendKeys(bf.getCityFirstLetter());
        inputZip.setValue(bf.getZip());

        inputCreditCardName.setValue(bf.getNameOnCard());
        inputCreditCardNumber.setValue(bf.getCreditCardNumber());
        inputExpiration.setValue(bf.getExpiration());
        inputCvv.setValue(bf.getCvv());
        AttachmentsHelper.attachScreenshot("Before `continue to checkout` push");

        btnCheckout.click();
    }
}

