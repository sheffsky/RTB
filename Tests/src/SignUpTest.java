import Pages.RegistrationPages.SignUpPage;
import Pages.RegistrationPages.TeamPage;
import Pages.Texts;
import Utils.Utils;
import com.codeborne.selenide.*;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class SignUpTest {

    private SignUpPage signUpPage;
    private String locale;

    private Utils utils = new Utils();

    @BeforeClass
    public void setUp() {
        WebDriverRunner.setWebDriver(utils.getWebDriver());
        locale = "en"; //todo: get locale from gradle or testng param
        String url = System.getProperty("build.baseUrl", "https://realtimeboard.com/");
        Configuration.baseUrl = url + locale + "/";
    }

    @AfterClass
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @BeforeMethod
    public void preparePage() {
        signUpPage = new SignUpPage();
    }

    @Test(dataProvider = "createIncorrectNonEmptyPasswords")
    public void incorrectPasswords(String password) {
        signUpPage.fillIncorrectValuesAndSubmit("Tester", "test@test.com", password);
        $(withText(Texts.SIGNUPPAGE_PASSWORD_MORE_THAN_6.getText(locale))).shouldBe(visible);
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
        $(withText(Texts.SIGNUPPAGE_ENTER_YOUR_PASSWORD.getText(locale))).shouldBe(visible);
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
        $(withText(Texts.SIGNUPPAGE_ENTER_YOUR_NAME.getText(locale))).shouldBe(visible);
        $(withText(Texts.SIGNUPPAGE_ENTER_YOUR_EMAIL.getText(locale))).shouldBe(visible);
        $(withText(Texts.SIGNUPPAGE_ENTER_YOUR_PASSWORD.getText(locale))).shouldBe(visible);
    }

    @Test
    public void emptyEmail() {
        signUpPage.fillIncorrectValuesAndSubmit("Tester", "", "password");
        $(withText(Texts.SIGNUPPAGE_ENTER_YOUR_EMAIL.getText(locale))).shouldBe(visible);
    }

    @Test
    public void emptyName() {
        signUpPage.fillIncorrectValuesAndSubmit("", "test@test.com", "password");
        $(withText(Texts.SIGNUPPAGE_ENTER_YOUR_NAME.getText(locale))).shouldBe(visible);
    }

    @Test(dataProvider = "createIncorrectEmails")
    public void incorrectEmail(String email) {
        signUpPage.fillIncorrectValuesAndSubmit("Tester", email, "password");
        $(withText(Texts.SIGNUPPAGE_INCORRECT_EMAIL.getText(locale))).shouldBe(visible);
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
        String email = utils.generateUniqueCorrectEmail();
        signUpPage.fillCorrectValuesAndSubmit("Tester", email, "pAsSwoRd");
        $(withText(Texts.TEAMPAGE_ADD_TEAM_DETAILS_CAPTION.getText(locale))).shouldBe(visible);
    }


}
