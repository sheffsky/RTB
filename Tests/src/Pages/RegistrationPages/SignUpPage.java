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
        public enum Texts {
            ENTER_YOUR_NAME("Please enter your name",
                    "Пожалуйста, введите свое имя"),
            ENTER_YOUR_EMAIL("Please enter your email",
                    "Пожалуйста, введите email"),
            ENTER_YOUR_PASSWORD("Please enter your password",
                    "Пожалуйста, введите свой пароль"),
            PASSWORD_MORE_THAN_6("Please choose a password with at least 6 characters",
                    "Пожалуйста, введите минимум 6 символов"),
            INCORRECT_EMAIL("This doesn’t look like an email address. Please check it for typos and try again.",
                    "Email введен неверно. Пожалуйста, проверьте написание.");

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
