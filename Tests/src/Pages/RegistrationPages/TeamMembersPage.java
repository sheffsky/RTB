package Pages.RegistrationPages;

import Pages.Texts;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class TeamMembersPage {

    TeamMembersPage() {
    }

    public SelenideElement teamMembersText
            = $(withText(Texts.Constants.TEAMMEMBERS_CAPTION.toString()));
}
