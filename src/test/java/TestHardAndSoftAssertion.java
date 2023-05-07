import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class TestHardAndSoftAssertion {

    private WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDownDriver() {
        this.driver.quit();
    }

    @Test
    public void testGoogleHard() {
        // go to google.com
        this.driver.navigate().to("https://www.google.com");
        this.driver.findElement(By.xpath("//textarea[1]")).sendKeys("testng", Keys.ENTER);
        String currentTitle = this.driver.getTitle();
        assertEquals(currentTitle, "testng - Google Search!");
        System.out.println("Other UI testing in hard assertion...");
    }

    @Test
    public void testGoogleSoft() {
        SoftAssert softAssert = new SoftAssert();
        this.driver.navigate().to("https://www.google.com");
        this.driver.findElement(By.xpath("//textarea[1]")).sendKeys("testng", Keys.ENTER);
        String currentTitle = this.driver.getTitle();
        softAssert.assertEquals(currentTitle, "testng - Google Search!");
        System.out.println("Other UI testing in soft assertion...");
        softAssert.assertAll();
    }
}
