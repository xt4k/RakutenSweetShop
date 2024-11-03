package autotests.po;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Configuration.baseUrl;

public class BasePage {
    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    @Step("Open Main page")
    public MainPage openHome() {
        Selenide.open(baseUrl);
        return new MainPage();
    }
}