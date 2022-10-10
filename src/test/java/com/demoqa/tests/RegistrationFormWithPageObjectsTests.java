package com.demoqa.tests;
import com.demoqa.pages.RegistrationFormPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import java.io.File;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import com.codeborne.selenide.Configuration;
import com.demoqa.pages.components.ResultsModal;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @BeforeAll
    static void configure() {

        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    String firstName = "testman";
    String lastName = "testmanson";
    String userEmail = "test@test.test";
    String gender = "Other";
    String dayOfBirth = "30";
    String monthOfBirth = "July";
    String yearOfBirth = "2008";
    String subject = "Hindi";
    String currentAddress = "Far far away, building 3";
    String state = "Haryana";
    String city = "Panipat";
    String userNumber = "1234567890";
    String userHobbie = "Sports";
    String pictureName = "HW1.png";



        @Test
        void demoFormTest() {

            registrationFormPage.openPage()
                    .setFirstName(firstName)
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

        }
    }