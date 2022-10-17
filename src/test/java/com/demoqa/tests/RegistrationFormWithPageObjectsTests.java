package com.demoqa.tests;

import static io.qameta.allure.Allure.step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import utilities.MyUtilities;
import io.qameta.allure.selenide.AllureSelenide;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {

//        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    private Faker faker = new Faker();
    String firstName = faker.name().firstName();
    ;
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = faker.demographic().sex();
    ;
    String dayOfBirth = String.valueOf(faker.number().numberBetween(10, 27));
    ;
    String monthOfBirth = MyUtilities.monthName();
    String yearOfBirth = String.valueOf(faker.number().numberBetween(1980, 2000));
    ;
    String subject = "Hindi";
    String currentAddress = "Far far away, building 3";
    String state = "Haryana";
    String city = "Panipat";
    String userNumber = String.valueOf(faker.phoneNumber().subscriberNumber(10));
    String userHobbie = "Sports";
    String pictureName = "HW1.png";

    @Test
    void demoFormTest() {
        step("open page", () -> {
            registrationFormPage.openPage();
        });

        step("fill form", () -> {
            registrationFormPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(userNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbie(userHobbie)
                .setPicture(pictureName)
                .setAdress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm();
        });

        step("check form", () -> {
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Student Email", userEmail)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", userHobbie)
                .checkResult("Picture", pictureName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
        });
    }
}