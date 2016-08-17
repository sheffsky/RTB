package Pages.RegistrationPages;

public class TeamMembersPage {

    public enum Texts {
        TEAM_MEMBERS_CAPTION("Who's on your team?", "Who's on your team?");

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

    public TeamMembersPage() {
    }
}
