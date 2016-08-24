import Pages.RegistrationPages.SignUpPage;
import Pages.RegistrationPages.TeamMembersPage;
import Pages.RegistrationPages.TeamPage;
import Utils.*;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;

public class TeamTest extends RtbTest{

    private TeamPage teamPage;

    @BeforeMethod
    public void preparePage() {
        SignUpPage signUpPage = new SignUpPage();
        String email = Helpers.generateUniqueCorrectEmail();
        teamPage = signUpPage.fillCorrectValuesAndSubmit("Tester", email, "password");
    }

    @Test
    public void teamSizeIsNotSelected() {
        teamPage.fillIncorrectValuesAndSubmit("team", TeamPage.CompanySize.EMPTY, "123");
        teamPage.selectCompanySizeText.should(appear);
    }

    @Test
    public void emptyTeamName() {
        teamPage.fillIncorrectValuesAndSubmit("", TeamPage.CompanySize.SIZE_6_10, "123");
        teamPage.inputCompanyNameText.should(appear);
    }

    @Test
    public void correctValues() {
        TeamMembersPage teamMembersPage = teamPage.fillCorrectValuesAndSubmit("Mega Team !!", TeamPage.CompanySize.SIZE_6_10, "+7(111) 410-29-00");
        teamMembersPage.teamMembersText.shouldBe(visible);
    }

}
