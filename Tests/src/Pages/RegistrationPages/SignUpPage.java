package Pages.RegistrationPages;

import org.openqa.selenium.By;

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

    public static class SignUpErrorPage {

    }
}
