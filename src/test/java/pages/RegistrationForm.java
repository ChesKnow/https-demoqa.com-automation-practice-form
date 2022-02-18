package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {

    //components
    private CalendarComponents calendarComponents = new CalendarComponents();

    //locators
    private SelenideElement
            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive"),
            studentEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddress = $("#currentAddress"),
            gender = $("#genterWrapper"),
            hobbies = $("#hobbiesWrapper"),
            subject = $("#subjectsInput"),
            upload = $("#uploadPicture"),
            state = $("#state"),
            stateCity = $("#stateCity-wrapper"),
            city = $("#city");

    //actions
    public RegistrationForm openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));
        return this;
    }
    public RegistrationForm setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    public RegistrationForm setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationForm setUserEmail(String studentEmail) {
        studentEmailInput.setValue(studentEmail);
        return this;
    }

    public RegistrationForm setUserNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationForm setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public void setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponents.setDate(day, month, year);

    }

    public void setGender(String wrapperValue) {
        gender.$(byText(wrapperValue)).click();
    }

    public RegistrationForm setHobbies(String wrapperValue) {
        hobbies.$(byText(wrapperValue)).click();
        return this;
    }

    public void enterSubject(String subjectName) {
        subject.setValue(subjectName).pressEnter();
    }

    public void uploadPicture(String PictureName) {
        upload.uploadFromClasspath(PictureName);
    }

    public void setState(String stateName) {
        state.scrollTo().click();
        stateCity.$(byText(stateName)).click();
    }

    public void setCity(String cityName) {
        city.click();
        stateCity.$(byText(cityName)).click();
    }

    public void submitForm() {
        $("#submit").click();
    }

    public void checkSubmitOk() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public RegistrationForm checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName)).parent().shouldHave(text(value));
        return this;
    }
}

