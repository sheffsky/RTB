package Pages.RegistrationPages;

import Pages.Texts;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class TeamPage {

    public enum CompanySize {
        EMPTY(""),
        SIZE_2_5("2 - 5"),
        SIZE_6_10("6 - 10");

        private final String name;

        CompanySize(String s) {
            name = s;
        }

        public String getName() {
            return name;
        }
    }

    TeamPage() {
        $(withText("Loading")).waitUntil(Condition.disappear, 50000);
    }

    private void fillValuesAndSubmit(String team, CompanySize companySize, String phone) {
        $(By.cssSelector("[ng-model=\"welcomeScreen.ctrl.teamName\"]")).val(team);
        if (companySize != CompanySize.EMPTY) {
            $(By.cssSelector("[ng-model=\"welcomeScreen.ctrl.selectedOption\"]")).selectOption(companySize.getName());
        }
        $(By.cssSelector("[ng-model=\"welcomeScreen.ctrl.teamPhone\"]")).val(phone);
        $(By.cssSelector(".welcomeScreen_bigButton")).click();
    }

    public TeamErrorPage fillIncorrectValuesAndSubmit(String team, CompanySize companySize, String phone) {
        fillValuesAndSubmit(team, companySize, phone);
        return new TeamErrorPage();
    }

    public TeamMembersPage fillCorrectValuesAndSubmit(String team, CompanySize companySize, String phone) {
        fillValuesAndSubmit(team, companySize, phone);
        return new TeamMembersPage();
    }

    public SelenideElement selectCompanySizeText
            = $(withText(Texts.Constants.TEAMPAGE_SELECT_COMPANY_SIZE_ALERT.toString()));

    public SelenideElement inputCompanyNameText
            = $(withText(Texts.Constants.TEAMPAGE_INPUT_COMPANY_NAME_ALERT.toString()));

    public static class TeamErrorPage {

    }


}
