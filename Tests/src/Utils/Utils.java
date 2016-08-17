package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class Utils {
    public WebDriver getWebDriver() {
        String driver = System.getProperty("testdriver.env", "chrome");

        switch (driver)
        {
            case "chrome":
                return new ChromeDriver();
            case "phantomJs":
                return new PhantomJSDriver();
            case "firefox":
                return new FirefoxDriver();
            case "htmlunit":
                return new HtmlUnitDriver(true);
            default:
                return new HtmlUnitDriver(true);
        }
    }

    public String generateUniqueCorrectEmail() {
        return System.currentTimeMillis() + "@test.com";
    }
}
