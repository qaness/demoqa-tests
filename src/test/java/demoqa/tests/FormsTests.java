package demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class FormsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Nasty");
        $("#lastName").setValue("Belova");
     //   $("#currentAddress").setValue("Some address 1");
     //   $("#permanentAddress").setValue("Another address 1");
     //   $("#submit").click();

     //   $("#output #name").shouldHave(text("Alex Egorov"));
     //   $("#output #email").shouldHave(text("alex@egorov.com"));
     //   $("#output #currentAddress").shouldHave(text("Some address 1"));
     //   $("#output #permanentAddress").shouldHave(text("Another address 1"));
    }

}
