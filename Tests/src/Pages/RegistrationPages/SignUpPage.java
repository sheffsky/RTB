package Pages.RegistrationPages;

import Pages.Texts;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignUpPage {

    public SignUpPage() {
        open("signup/");
    }

    public SignUpErrorPage fillIncorrectValuesAndSubmit(String name, String email, String password) {
        fillValuesAndSubmit(name, email, password);
        return new SignUpErrorPage();
    }

    public TeamPage fillCorrectValuesAndSubmit(String name, String email, String password) {
        fillValuesAndSubmit(name, email, password);
        return new TeamPage();
    }

    private void fillValuesAndSubmit(String name, String email, String password) {
        $(By.id("name")).val(name);
        $(By.id("email")).val(email);
        $(By.id("password")).val(password);
        $(By.id("password")).submit();
    }

    public SelenideElement needPasswordMoreThan6LettersText
            = $(withText(Texts.Constants.SIGNUPPAGE_NEED_PASSWORD_MORE_THAN_6.toString()));

    public SelenideElement enterYourPasswordText
            = $(withText(Texts.Constants.SIGNUPPAGE_ENTER_YOUR_PASSWORD.toString()));

    public SelenideElement enterYourNameText
            = $(withText(Texts.Constants.SIGNUPPAGE_ENTER_YOUR_NAME.toString()));

    public SelenideElement enterYourEmailText
            = $(withText(Texts.Constants.SIGNUPPAGE_ENTER_YOUR_EMAIL.toString()));

    public SelenideElement incorrectEmailText
            = $(withText(Texts.Constants.SIGNUPPAGE_INCORRECT_EMAIL.toString()));

    public SelenideElement addTeamDetailsText
            = $(withText(Texts.Constants.TEAMPAGE_ADD_TEAM_DETAILS_CAPTION.toString()));

    public static class SignUpErrorPage {

    }
}
