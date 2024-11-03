package autotests.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    SelenideElement loginPageHeader = $("display-3");
    SelenideElement inputEmail = $("#exampleInputEmail");
    SelenideElement inputPassword = $("#exampleInputPassword");
    SelenideElement btnLogin = $("button[type='submit']");


    @Step("Get Login page header text")
    public String getPageHeader() {
        return loginPageHeader.getText();
    }

    @Step("Set `email address` field")
    public LoginPage setEmailAddress(String email) {
        inputEmail.setValue(email);
        return new LoginPage();
    }

    @Step("Set password field")
    public LoginPage setPassword(String password) {
        inputPassword.setValue(password);
        return new LoginPage();
    }


    @Step("Push button `Login`")
    public AccountPage logIn() {
        btnLogin.click();
        return new AccountPage();
    }


}
