import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApfTestAutomation {

    @BeforeAll
    static void startPage() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void apfTest() {
        open("/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Ivanushka");
        $("#lastName").setValue("Durachok");
        $("#userEmail").setValue("VanyaDuren@tridevyatoe.ru");
        $("#userNumber").setValue("0102030405");

        $("div.custom-radio:nth-child(1) > label:nth-child(2)").click();

        $("div.custom-checkbox:nth-child(1)").click();
        $("div.custom-checkbox:nth-child(2)").click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("2012");
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__day--021").click();

        $("#uploadPicture").uploadFromClasspath("Photo.jpg");

        $("#currentAddress").scrollTo().setValue("Tridevyatoe Tsartsvo, Dvorets, Palata #1");

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $(".table > thead:nth-child(1)").shouldHave(text("Label"), text("Values"));
        $(".table > tbody:nth-child(2)").shouldHave(text("Ivanushka"), text("Durachok"),
                text("VanyaDuren@tridevyatoe.ru"), text("0102030405"), text("21 March,2012"), text("Photo.jpg"),
                text("Tridevyatoe Tsartsvo, Dvorets, Palata #1"), text("NCR Delhi"));

        $("#close-fixedban").click();
        $("#closeLargeModal").scrollTo().click();




    }
}
