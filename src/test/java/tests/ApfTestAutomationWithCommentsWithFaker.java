package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApfTestAutomationWithCommentsWithFaker extends TestBase {

    Faker faker = new Faker();
    //Faker faker = new Faker(new Locale("ru"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().streetAddress();

    @Test
    void apfTest() {
        open("/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
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

        $("#currentAddress").scrollTo().setValue(currentAddress);

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        //$("#react-select-3-input").setValue("NCR").pressEnter();
        //$("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName),
                text(email), text("0102030405"), text("21 March,2012"), text("Photo.jpg"),
                text(currentAddress), text("NCR Delhi"));
    }
}
