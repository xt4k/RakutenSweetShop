package autotests.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends BasePage {

    SelenideElement lblWelcomeMessage = $("p.lead");
    SelenideElement hdrPage = $("h1.display-3");

    @Step("Get welcome message text")
    public String getWelcomeMessage() {
       return lblWelcomeMessage.getText();
    }

    @Step("Get Account page Header text")
    public String getAccountPageHeader() {
        return hdrPage.getText();
    }
}
