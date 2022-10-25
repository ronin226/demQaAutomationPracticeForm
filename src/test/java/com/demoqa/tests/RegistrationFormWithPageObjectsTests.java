package com.demoqa.tests;

import static io.qameta.allure.Allure.step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import utilities.Attacments;
import utilities.MyUtilities;
import io.qameta.allure.selenide.AllureSelenide;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {

//        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.remote = System.getProperty("remote");
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
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
            Attacments.screenshotAs("screen1");
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
                Attacments.browserConsoleLogs();
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
                Attacments.pageSource();
        });
        Attacments.addVideo();
    }
}