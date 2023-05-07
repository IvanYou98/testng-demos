package dataprovider_test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestParallelExecution {
    private LocalDateTime startTime;

    @BeforeTest
    public void startTime() {
        this.startTime = LocalDateTime.now();
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "parallelDataSource")
    public void testParallel(Object[] data) throws InterruptedException {
        Thread.sleep(1000);
    }

    @AfterTest
    public void endTime() {
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("The entire execution took: " +
                duration.getSeconds() + " seconds");
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
    }

}
