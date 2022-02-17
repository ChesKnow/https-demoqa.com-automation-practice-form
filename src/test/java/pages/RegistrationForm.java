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
            resultsTable = $(".table-responsive");

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

    public void setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponents.setDate(day, month, year);

    }

    public RegistrationForm checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName)).parent().shouldHave(text(value));
        return this;
    }
}

