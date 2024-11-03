package autotests.tests;

import autotests.helpers.AttachmentsHelper;
import autotests.po.BasePage;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static autotests.drivers.DriverHelper.configureDriver;
import static autotests.helpers.AttachmentsHelper.attachPageSource;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@ExtendWith({AllureJunit5.class})
public class TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(TestBase.class);
    public static BasePage po = new BasePage();

    @BeforeAll
    static void setUp() {
        configureDriver();
    }

    @AfterEach
    public void addAttachments() {
        AttachmentsHelper.attachScreenshot("Last screenshot");
        attachPageSource();
        closeWebDriver();
    }

}
