package demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillingFormSuccessTest() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //Input fields
        $("#firstName").setValue("Nasty");
        $("#lastName").setValue("Belova");
        $("#userEmail").setValue("email@example.com");
        $("#userNumber").setValue("9998887766");
        $("#currentAddress").setValue("Pushkina st., Kolotushkina b.");

        // Date & drop-down
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("a");
        $("#subjectsWrapper").$(byText("Arts")).click();

        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Panipat")).click();

        //Radio & checkbox
        $("#genterWrapper").$(byText("Female")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        //Upload Image field
        $("#uploadPicture").uploadFromClasspath("example.png");

        $("#submit").click();

        // assertions
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("Nasty Belova"));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text("email@example.com"));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text("9998887766"));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text("30 August,1991"));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("example.png"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text("Pushkina st., Kolotushkina b."));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text("Haryana Panipat"));

    }

}
