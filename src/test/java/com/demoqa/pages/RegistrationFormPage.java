package com.demoqa.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import java.io.File;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

public class RegistrationFormPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal resultsModal = new ResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            genderInput = $("#genterWrapper"),
            subjectInput = $("#subjectsInput"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            hobbieInput = $("#hobbiesWrapper"),
            pictureInput = $("input#uploadPicture"),
            adressInput = $("textarea#currentAddress"),
            submitButton = $("#submit"),
            stateInput = $("#state"),
            cityInput = $("#city");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage clearFirstName() {
        firstNameInput.clear();

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setHobbie(String value) {
        hobbieInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();

        return this;
    }

    public RegistrationFormPage setPicture(String value) {
        pictureInput.uploadFile(new File("src/test/resources/" + value));

        return this;
    }

    public RegistrationFormPage setAdress(String value) {
        adressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateInput.click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityInput.click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage submitForm() {
        submitButton.click();
        ;

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);

        return this;
    }
}
