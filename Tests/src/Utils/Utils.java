package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Utils {
    public static WebDriver getWebDriver() {
        String driver = System.getProperty("testdriver.env", "chrome");
        String gridUrl = System.getProperty("remoteurl.env", "http://localhost:4444/wd/hub");

        switch (driver)
        {
            case "chrome":
                return new ChromeDriver();
            case "chromeGrid":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
                try {
                    return new RemoteWebDriver(new URL(gridUrl), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            case "phantomJs":
                return new PhantomJSDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }
}