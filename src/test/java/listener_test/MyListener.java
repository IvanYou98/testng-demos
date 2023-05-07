package listener_test;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class MyListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " is success!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " is failed!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        result.getSkipCausedBy().forEach(method -> System.out.println(result.getMethod().getMethodName() + " is skipped, " +
                "caused by " + method.getMethodName()));
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " is failed with timeout.");
        long startTime = result.getStartMillis();
        long endTime = result.getEndMillis();
        System.out.println("duration: " + (endTime - startTime) / 1000 + " s");
    }
}
