package screenshot_demo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return this.driver.get();
    }

    @BeforeMethod
    @Parameters("driverType")
    public void setupDriver(String driverType) {
        switch (driverType.toLowerCase()) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                this.driver.set(new ChromeDriver());
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                this.driver.set(new FirefoxDriver());
                break;
            }
            default: {
                throw new IllegalArgumentException("The driver type is not supported!");
            }
        }
        System.out.println("current thread id: " + Thread.currentThread().getId());
        this.driver.get().manage().window().maximize();
        this.driver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() {
        this.driver.get().quit();
        this.driver.remove();
    }

}
