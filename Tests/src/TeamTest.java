import Pages.RegistrationPages.SignUpPage;
import Pages.RegistrationPages.TeamPage;
import Utils.Utils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class TeamTest {

    private SignUpPage signUpPage;
    private String locale;

    private Utils utils = new Utils();
    private TeamPage teamPage;

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
        String email = utils.generateUniqueCorrectEmail();
        teamPage = signUpPage.fillCorrectValuesAndSubmit("Tester", email, "password");
    }

    @Test
    public void teamSizeIsNotSelected() {
        teamPage.fillIncorrectValuesAndSubmit("team", TeamPage.CompanySize.EMPTY, "123");
        $(withText(TeamPage.TeamErrorPage.Texts.SELECT_COMPANY_SIZE_ALERT.getText(locale))).should(appear);
    }

    @Test
    public void emptyTeamName() {
        teamPage.fillIncorrectValuesAndSubmit("", TeamPage.CompanySize.SIZE_6_10, "123");
        $(withText(TeamPage.TeamErrorPage.Texts.INPUT_COMPANY_NAME_ALERT.getText(locale))).should(appear);
    }

    @Test
    public void correctValues() {
        teamPage.fillCorrectValuesAndSubmit("Mega Team !!", TeamPage.CompanySize.SIZE_6_10, "+7(111) 410-29-00");
    }

}
