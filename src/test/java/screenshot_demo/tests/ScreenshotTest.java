package screenshot_demo.tests;

import screenshot_demo.DataProviders;
import screenshot_demo.listeners.ScreenshotListener;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ScreenshotListener.class)
public class ScreenshotTest extends BaseTest {
    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "userCredentialsProvider")
    public void loginToOrangeHRM(String username, String password) {
        getDriver().navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        getDriver().findElement(By.xpath("//*[@name = 'username']")).sendKeys(username);
        getDriver().findElement(By.xpath("//*[@name = 'password']")).sendKeys(password, Keys.ENTER);
        getDriver().findElement(By.xpath("//img[@alt = 'profile picture']"));
    }

}
