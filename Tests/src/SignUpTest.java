import Pages.RegistrationPages.SignUpPage;
import Utils.*;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;

public class SignUpTest extends RtbTest {

    private SignUpPage signUpPage;

    @BeforeMethod
    public void preparePage() {
        signUpPage = new SignUpPage();
    }

    @Test(dataProvider = "createIncorrectNonEmptyPasswords")
    public void incorrectPasswords(String password) {
        signUpPage.fillIncorrectValuesAndSubmit("Tester", "test@test.com", password);
        signUpPage.needPasswordMoreThan6LettersText.shouldBe(visible);
    }

    @DataProvider
    public Object[][] createIncorrectNonEmptyPasswords() {
        return new Object[][]{
                {"C"},
                {"test"},
                {"test  "},
                {"  test"}
        };
    }

    @Test(dataProvider = "createEmptyPasswords")
    public void emptyPasswords(String password) {
        signUpPage.fillIncorrectValuesAndSubmit("Tester", "test@test.com", password);
        signUpPage.enterYourPasswordText.shouldBe(visible);
    }

    @DataProvider
    public Object[][] createEmptyPasswords() {
        return new Object[][]{
                {""},
                {"       "}
        };
    }

    @Test
    public void allEmptyValues() {
        signUpPage.fillIncorrectValuesAndSubmit("", "", "");
        signUpPage.enterYourNameText.shouldBe(visible);
        signUpPage.enterYourEmailText.shouldBe(visible);
        signUpPage.enterYourPasswordText.shouldBe(visible);
    }

    @Test
    public void emptyEmail() {
        signUpPage.fillIncorrectValuesAndSubmit("Tester", "", "password");
        signUpPage.enterYourEmailText.shouldBe(visible);
    }

    @Test
    public void emptyName() {
        signUpPage.fillIncorrectValuesAndSubmit("", "test@test.com", "password");
        signUpPage.enterYourNameText.shouldBe(visible);
    }

    @Test(dataProvider = "createIncorrectEmails")
    public void incorrectEmail(String email) {
        signUpPage.fillIncorrectValuesAndSubmit("Tester", email, "password");
        signUpPage.incorrectEmailText.shouldBe(visible);
    }

    @DataProvider
    public Object[][] createIncorrectEmails() {
        return new Object[][]{
                {"q"},
                {"1@c"},
                {"te s t@do main.net"},
                {"test@test.com@com.com"}
        };
    }

    @Test
    public void correctValues() {
        String email = Helpers.generateUniqueCorrectEmail();
        signUpPage.fillCorrectValuesAndSubmit("Tester", email, "pAsSwoRd");
        signUpPage.addTeamDetailsText.shouldBe(visible);
    }


}
