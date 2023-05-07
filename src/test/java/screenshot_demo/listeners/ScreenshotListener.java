package screenshot_demo.listeners;

import org.testng.Reporter;
import screenshot_demo.tests.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;


public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("current test instance is: " + result.getInstance());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(result);
    }

    private void takeScreenshot(ITestResult testResult) {
        BaseTest testInstance = (BaseTest) testResult.getInstance();
        String folderName = "src/test/screenshots";
        WebDriver driver = testInstance.getDriver();
        String fileName = testResult.getName() +
                LocalDateTime.now() +
                ".jpg";
        try {
            Path savedPath = Files.write(Paths.get(folderName, fileName),
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            Reporter.log("Test failed: " + testResult.getName());
            Reporter.log("<br><img alt='screenshot' src='../" + savedPath + "' height='540' width='960'/><br>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
