package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationForm;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApfTestAutomationWithPageObject {

    RegistrationForm registrationPage = new RegistrationForm();
    String firstName = "Ivanushka";

    @BeforeAll
    static void startPage() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void apfTest() {
        open("/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName("Durachok");
        $("#userEmail").setValue("VanyaDuren@tridevyatoe.ru");
        $("#userNumber").setValue("0102030405");

        $("div.custom-radio:nth-child(1) > label:nth-child(2)").click();

        $("div.custom-checkbox:nth-child(1)").click();
        $("div.custom-checkbox:nth-child(2)").click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("2012");
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__day--021").click();

        $("#subjectsInput").setValue("Math").pressEnter();

        $("#uploadPicture").uploadFromClasspath("Photo.jpg");

        $("#currentAddress").scrollTo().setValue("Tridevyatoe Tsartsvo, Dvorets, Palata #1");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkForm("Student Name", firstName + " Durachok");
        registrationPage.checkForm("Student Email", "VanyaDuren@tridevyatoe.ru");
        registrationPage.checkForm("Gender", "Male");

    }
}
