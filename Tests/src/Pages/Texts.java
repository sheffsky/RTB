package Pages;


public class Texts {

    private static Locale locale = Locale.EN;

    public static Locale getLocale() {
        return locale;
    }

    public static void setLocale(Locale newLocale) {
        locale = newLocale;
    }

    public enum Locale {RU, EN}

    public enum Constants {
        TEAMPAGE_ADD_TEAM_DETAILS_CAPTION("Add your team details", "Добавьте информацию о вашей команде"),
        TEAMPAGE_SELECT_COMPANY_SIZE_ALERT("Please select company size", "Please select company size"),
        TEAMPAGE_INPUT_COMPANY_NAME_ALERT("Please enter a team name", "Please enter a team name"),
        TEAMMEMBERS_CAPTION("Who's on your team?", "Кто в вашей команде?"),
        SIGNUPPAGE_ENTER_YOUR_NAME("Please enter your name",
                "Пожалуйста, введите свое имя"),
        SIGNUPPAGE_ENTER_YOUR_EMAIL("Please enter your email",
                "Пожалуйста, введите email"),
        SIGNUPPAGE_ENTER_YOUR_PASSWORD("Please enter your password",
                "Пожалуйста, введите свой пароль"),
        SIGNUPPAGE_NEED_PASSWORD_MORE_THAN_6("Please choose a password with at least 6 characters",
                "Пожалуйста, введите минимум 6 символов"),
        SIGNUPPAGE_INCORRECT_EMAIL("This doesn’t look like an email address. Please check it for typos and try again.",
                "Email введен неверно. Пожалуйста, проверьте написание.");

        private final String nameEn;
        private final String nameRu;


        Constants(String en, String ru) {
            nameEn = en;
            nameRu = ru;
        }

        @Override
        public String toString() {
            switch (locale) {
                case RU:
                    return nameRu;
                case EN:
                    return nameEn;
                default:
                    return nameEn;
            }
        }
    }
}