
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class HomeTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.pageLoadStrategy = "eager";
        //Configuration.timeout = 1000; // default 4000
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    RegistrationPage registrationPage = new RegistrationPage();

    String gender = RandomUtils.getRandomGender();
    String dateOfBirth1 = RandomUtils.getRandomDateOfBirth1()+"";
    String dateOfBirth2 = RandomUtils.getRandomMonth();
    String dateOfBirth3 = RandomUtils.getRandomDateOfBirth3()+"";
    String uploadPicture = RandomUtils.getRandomJpg();
    String subjectsInput = RandomUtils.getRandomSubjectsInput();
    String hobbiesWrapper = RandomUtils.getRandomHobbiesWrapper();
    String state = RandomUtils.getRandomState();
    String сity = RandomUtils.getRandomCity(state);

    @Test
    void fillFormTest() {

        registrationPage
                .openPage()
                .hidebanner()
                .setFirstName(TestData.firstname)
                .setLastName(TestData.lastName)
                .setEmail(TestData.email)
                .setCurrentAddress(TestData.currentAddress)
                .setGender(gender)
                .setDateOfBirth(dateOfBirth1, dateOfBirth2, dateOfBirth3)
                .setUserNumber(TestData.phoneNumber)
                .setUploadPicture(uploadPicture)
                .setSubjectsInput(subjectsInput)
                .setHobbiesWrapper(hobbiesWrapper)
                .setState(state)
                .setCity(сity)
                .setSubmit()
        ;

        //Проверки:
        registrationPage
                .checkResult("Student Name", TestData.firstname +" " +TestData.lastName)
                .checkResult("Student Email", TestData.email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", TestData.phoneNumber)
                .checkResult("Date of Birth", dateOfBirth1 + " "+ dateOfBirth2 + "," + dateOfBirth3)
                .checkResult("Subjects", subjectsInput)
                .checkResult("Hobbies", hobbiesWrapper)
                .checkResult("Picture", uploadPicture)
                .checkResult("Address", TestData.currentAddress)
                .checkResult("State and City", state + " " + сity)
        ;
    }
}