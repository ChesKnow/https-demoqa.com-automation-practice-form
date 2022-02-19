package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class ApfTestAutomationWithCommentsWithRandomUtils extends TestBase {



    @Test
    void apfTest() {
        open("/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("VanyaDuren@tridevyatoe.ru");
        $("#userNumber").setValue("0102030405");

        $("#gender-radio-1").parent().click();

        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-2").parent().click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2012");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--021:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("Math").pressEnter();

        $("#uploadPicture").uploadFromClasspath("Photo.jpg");

        $("#currentAddress").scrollTo().setValue("Tridevyatoe Tsartsvo, Dvorets, Palata #1");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        //$("#react-select-3-input").setValue("NCR").pressEnter();
        //$("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName),
                text("VanyaDuren@tridevyatoe.ru"), text("0102030405"), text("21 March,2012"), text("Photo.jpg"),
                text("Tridevyatoe Tsartsvo, Dvorets, Palata #1"), text("NCR Delhi"));
    }
}
