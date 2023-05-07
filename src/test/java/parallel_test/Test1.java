package parallel_test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void method1() {
        printMsg("method1");
    }

    @Test
    public void method2() {
        printMsg("method2");
    }

    @Test
    public void method3() {
        printMsg("method3");
    }

    private void printMsg(String methodName) {
        System.out.println("Thread " + Thread.currentThread().getId() + " is executing " + methodName + " of " + getClass().getName());
    }
}
