package parallel_test;

import org.testng.annotations.*;

public class TestInvocationAndDataProvider {
    private Long startTime;
    @Test(invocationCount = 5, threadPoolSize = 3)
    public void testMethodInvocation() throws InterruptedException{
        System.out.println(Thread.currentThread().getId() + " is running.");
        Thread.sleep(1000);
    }

    @DataProvider(parallel = true)
    public Object[][] myDataProvider() {
        return new Object[][] {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8},
        };
    }

    @Test(dataProvider = "myDataProvider")
    public void testDataProvider(int a, int b) throws InterruptedException {
        System.out.println(Thread.currentThread().getId() + " is running... \n" +
                "a: " + a + ", b: " + b);
        Thread.sleep(1000);
    }

    @BeforeTest
    public void startTimer() {
        this.startTime = System.currentTimeMillis();
    }

    @AfterTest
    public void stopTimer() {
        long now = System.currentTimeMillis();
        System.out.println("Test execution takes: " + (now - startTime) / 1000 + " seconds.");
    }
}
