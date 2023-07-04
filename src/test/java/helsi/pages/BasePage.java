package helsi.pages;

import com.codeborne.selenide.SelenideElement;
import helsi.helpers.Attach;
import helsi.tests.TestBase;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BasePage {
    protected static final Logger log = LoggerFactory.getLogger(TestBase.class);

    public BasePage() {

    }

    @Step("Search result should be greater than '{expectedMore}'")
    public void resultShouldBeMoreThan(SelenideElement element, int expectedMore) {
        String number = element.text().split(":")[1].trim();
        log.info("text on element: " + element.text());
        assertThat(Integer.parseInt(number)).isGreaterThan(expectedMore).describedAs("Expected that found result more than %s",expectedMore);
    }

    @Step("Attach test design screenshot and page source for method {methodName}")
    public void getShot(String methodName) {
        Attach.screenshotAs("Screenshot for method: " + methodName);
        Attach.pageSource();
    }
}