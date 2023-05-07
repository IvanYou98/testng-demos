import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.*;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class TestParameters {
    private WebDriver driver;


    @Parameters("browserType")
    @BeforeTest
    public void setupWebDriver(@Optional(value = "chrome") String browserType)
    {
        switch (browserType.toLowerCase()) {
            case "chrome" : {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case "firefox" : {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            default: {
                System.err.println("The browser type is not supported!");
            }
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDownDriver() {
        driver.quit();
    }

    @Parameters("url")
    @Test
    public void launchApp(String url) {
        driver.navigate().to(url);
    }

    @Parameters({"username", "password"})
    @Test
    public void enterLoginDetails(String username,
                                  String password) {

        driver.findElement(By.xpath("//*[@name = 'username']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@name = 'password']")).sendKeys(password, Keys.ENTER);
    }

    @Test
    @Parameters("nickname")
    public void verifyLogin() {
        String nickName = driver.findElement(By.xpath("//img[@alt = 'profile picture']/following-sibling::*[1]")).getText();
        assertEquals(nickName, "Paul Collings");
    }
}
