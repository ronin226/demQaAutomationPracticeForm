import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import java.io.File;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

public class FormTest {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
    }

    String firstName = "testman";
    String lastName = "testmanson";
    String userEmail = "test@test.test";
    String dateOfBirth = "11 December,2000";
    String subject = "Hindi";
    String currentAddress = "Far far away, building 3";
    String state = "Haryana";
    String city = "Panipat";
    String userNumber = "1234567890";

    @Test
    void demoFormTest() {

        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        //executeJavaScript("arguments[0].remove();", $("footer"));
        $("input#firstName").setValue(firstName);
        $("input#lastName").setValue(lastName);
        $("input#userEmail").setValue(userEmail);
        //$(By.name("gender")).selectRadio("Female");
        $("[for=\"gender-radio-2\"]").click();
        $("input#userNumber").setValue(userNumber);
        $("input#dateOfBirthInput").sendKeys(Keys.chord(Keys.CONTROL, "A"),dateOfBirth);
        //$("input#dateOfBirthInput").setValue(dateOfBirth).pressEnter();
        $("input#subjectsInput").setValue(subject).pressEnter();
        //$("subjects-auto-complete__input").setValue(subject);
        $(byText("Sports")).click();
        $("input#uploadPicture").uploadFile(new File("src/resourses/HW1.png"));
        $("textarea#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        //SelenideElement table = $(".table-dark tbody");
        //table.$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-dark tbody tr:nth-of-type(1) ").shouldHave(text("Student Name")).shouldHave(text(firstName + " " + lastName));
        $(".table-dark tbody tr:nth-of-type(2) ").shouldHave(text("Student Email")).shouldHave(text(userEmail));
        $(".table-dark tbody tr:nth-of-type(3) ").shouldHave(text("Gender")).shouldHave(text("Female"));
        $(".table-dark tbody tr:nth-of-type(4) ").shouldHave(text("Mobile")).shouldHave(text(userNumber));
        $(".table-dark tbody tr:nth-of-type(5) ").shouldHave(text("Date of Birth")).shouldHave(text(dateOfBirth));
        $(".table-dark tbody tr:nth-of-type(6) ").shouldHave(text("Subjects")).shouldHave(text(subject));
        $(".table-dark tbody tr:nth-of-type(7) ").shouldHave(text("Hobbies")).shouldHave(text("Sports"));
        $(".table-dark tbody tr:nth-of-type(8) ").shouldHave(text("Picture")).shouldHave(text("HW1.png"));
        $(".table-dark tbody tr:nth-of-type(9) ").shouldHave(text("Address")).shouldHave(text(currentAddress));
        $(".table-dark tbody tr:nth-of-type(10) ").shouldHave(text("State and City")).shouldHave(text(state + " " + city));




    };

};