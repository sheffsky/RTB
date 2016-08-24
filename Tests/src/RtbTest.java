import Pages.Texts;
import Utils.Utils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class RtbTest {

    @BeforeClass
    public void setUp() {
        WebDriverRunner.setWebDriver(Utils.getWebDriver());
        String urlLocale = "en";
        Texts.setLocale(Texts.Locale.EN);
        String url = System.getProperty("build.baseUrl", "https://realtimeboard.com/");
        Configuration.baseUrl = url + urlLocale + "/";
    }

    @AfterClass
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
