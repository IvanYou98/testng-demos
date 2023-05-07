package parallel_test;

import org.testng.annotations.Test;

public class Test2 {
    @Test
    public void method1() {
        printMsg(Thread.currentThread().getId(), "method1");
    }

    @Test
    public void method2() {
        printMsg(Thread.currentThread().getId(), "method2");
    }

    @Test
    public void method3() {
        printMsg(Thread.currentThread().getId(), "method3");
    }

    private void printMsg(Long threadId, String methodName) {
        System.out.println("Thread " + threadId + " is executing " + methodName + " of " + getClass().getName());
    }
}
