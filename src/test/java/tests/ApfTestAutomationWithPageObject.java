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
    String studentEmail = "VanyaDuren@tridevyatoe.ru";
    String studentNumber = "0102030405";
    String currentAddress = "Tridevyatoe Tsartsvo, Dvorets, Palata #1";
    String gender = "Male";
    String hobbies1 = "Sports";
    String hobbies2 = "Music";
    String subject = "Maths";
    String pictureName = "Photo.jpg";
    String state = "NCR";
    String city = "Noida";
    String day = "21";
    String month = "March";
    String year = "2012";

    @BeforeAll
    static void startPage() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void apfTest() {


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(studentEmail)
                .setUserNumber(studentNumber)
                .setCurrentAddress(currentAddress);

        registrationPage.setGender(gender)
                .setHobby(hobbies1)
                .setHobby(hobbies2);

        registrationPage.setBirthDate(day, month, year);

        registrationPage.enterSubject(subject);

        registrationPage.uploadPicture(pictureName);

        registrationPage.setState(state);
        registrationPage.setCity(city);

        registrationPage.submitForm();

        registrationPage.checkSubmitOk();

        registrationPage.checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", studentEmail)
                .checkForm("Gender", gender)
                .checkForm("Mobile", studentNumber)
                .checkForm("Date of Birth", day + " " + month + "," + year)
                .checkForm("Subjects", subject)
                .checkForm("Hobbies", hobbies1 + ", " + hobbies2)
                .checkForm("Picture", pictureName)
                .checkForm("Address", currentAddress)
                .checkForm("State and City", state + " " + city);

    }
}
