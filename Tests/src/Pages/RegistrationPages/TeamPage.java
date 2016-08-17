package Pages.RegistrationPages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class TeamPage {

    public enum Texts {
        ADD_TEAM_DETAILS_CAPTION("Add your team details", "Add your team details");

        private final String nameEn;
        private final String nameRu;

        Texts(String en, String ru) {
            nameEn = en;
            nameRu = ru;
        }

        public String getText(String locale) {
            switch (locale) {
                case "ru":
                    return nameRu;
                case "en":
                    return nameEn;
                default:
                    return nameEn;
            }
        }
    }

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

    public static class TeamErrorPage {

        public enum Texts {
            SELECT_COMPANY_SIZE_ALERT("Please select company size", "Please select company size"),
            INPUT_COMPANY_NAME_ALERT("Please enter a team name", "Please enter a team name");

            private final String nameEn;
            private final String nameRu;

            Texts(String en, String ru) {
                nameEn = en;
                nameRu = ru;
            }

            public String getText(String locale) {
                switch (locale) {
                    case "ru":
                        return nameRu;
                    case "en":
                        return nameEn;
                    default:
                        return nameEn;
                }
            }
        }

    }


}
