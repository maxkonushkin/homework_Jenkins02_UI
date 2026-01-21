import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBase {

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        // для борьбы с баннерами

        Configuration.pageLoadStrategy = "eager";
        //Configuration.timeout = 1000; // default 4000
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
    }
}