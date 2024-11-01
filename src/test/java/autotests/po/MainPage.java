package autotests.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class MainPage extends BasePage {
    String locatorPattern = "a[data-id='%s']";
    SelenideElement btnToBasketChocolateCup = $(format(locatorPattern, 1));
    SelenideElement btnToBasketSherbertDisc = $(format(locatorPattern, 3));
    SelenideElement btnToBasketSherbertStraw = $(format(locatorPattern, 2));
    SelenideElement btnToBasketBonBon = $(format(locatorPattern, 4));
    SelenideElement lnkBasket = $("a[href='/basket']");
    SelenideElement lnkLogin = $("a[href='/login']");


    @Step("Add to basket: `{number}` items of `Chocolate Cup`.")
    public MainPage addChocolateCupToBasket(int number) {
        clickAddToBasketButton(btnToBasketChocolateCup, number);
        return this;
    }

    @Step("Add to basket: `{number}` items of `Sherbert Disc`.")
    public MainPage addSherbertDiscToBasket(int number) {
        clickAddToBasketButton(btnToBasketSherbertDisc, number);
        return this;
    }

    @Step("Add to basket: `{number}` items of `Sherbert Straw`.")
    public MainPage addSherbertStrawBasket(int number) {
        clickAddToBasketButton(btnToBasketSherbertStraw, number);
        return this;
    }

    @Step("Add to basket: `{number}` items of `Bon Bon`.")
    public MainPage addBonBonToBasket(int number) {
        clickAddToBasketButton(btnToBasketBonBon, number);
        return this;
    }

    private void clickAddToBasketButton(SelenideElement se, int number) {
        for (int i = 0; i < number; i++) {
            se.click();

        }
    }

    @Step("Navigate to basket")
    public BasketPage goToBasket() {
        lnkBasket.click();
        return new BasketPage();
    }

    @Step("Navigate to Login page")
    public LoginPage goToLogin() {
        lnkLogin.click();
        return new LoginPage();
    }
}
