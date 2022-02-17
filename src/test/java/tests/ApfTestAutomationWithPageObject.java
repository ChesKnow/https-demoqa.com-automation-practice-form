package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationForm;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApfTestAutomationWithPageObject {

    RegistrationForm registrationPage = new RegistrationForm();
    String firstName = "Ivanushka";
    String lastName = "Durachok";

    @BeforeAll
    static void startPage() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void apfTest() {
        open("/automation-practice-form");

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName);
        $("#userEmail").setValue("VanyaDuren@tridevyatoe.ru");
        $("#userNumber").setValue("0102030405");

        $("#genterWrapper").$(byText("Male")).click();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        registrationPage.setBirthDate("21", "March", "2012");

        $("#subjectsInput").setValue("Math").pressEnter();

        $("#uploadPicture").uploadFromClasspath("Photo.jpg");

        $("#currentAddress").scrollTo().setValue("Tridevyatoe Tsartsvo, Dvorets, Palata #1");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", "VanyaDuren@tridevyatoe.ru")
                .checkForm("Gender", "Male");

    }
}
