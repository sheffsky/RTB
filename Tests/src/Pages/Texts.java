package Pages;

public enum Texts {
    TEAMPAGE_ADD_TEAM_DETAILS_CAPTION("Add your team details", "Add your team details"),
    TEAMPAGE_SELECT_COMPANY_SIZE_ALERT("Please select company size", "Please select company size"),
    TEAMPAGE_INPUT_COMPANY_NAME_ALERT("Please enter a team name", "Please enter a team name"),
    TEAMMEMBERS_CAPTION("Who's on your team?", "Who's on your team?"),
    SIGNUPPAGE_ENTER_YOUR_NAME("Please enter your name",
            "Пожалуйста, введите свое имя"),
    SIGNUPPAGE_ENTER_YOUR_EMAIL("Please enter your email",
            "Пожалуйста, введите email"),
    SIGNUPPAGE_ENTER_YOUR_PASSWORD("Please enter your password",
            "Пожалуйста, введите свой пароль"),
    SIGNUPPAGE_PASSWORD_MORE_THAN_6("Please choose a password with at least 6 characters",
            "Пожалуйста, введите минимум 6 символов"),
    SIGNUPPAGE_INCORRECT_EMAIL("This doesn’t look like an email address. Please check it for typos and try again.",
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
