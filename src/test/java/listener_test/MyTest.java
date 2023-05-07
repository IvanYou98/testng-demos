package listener_test;

import static org.testng.Assert.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(MyListener.class)
public class MyTest {
    @Test(priority = 0)
    public void testSuccess() {
        assertEquals(true, true);
    }

    @Test(timeOut = 1000L, priority = 1)
    public void testTimeout() throws InterruptedException{
        Thread.sleep(1500);
    }

    @Test(priority = 2)
    public void testDependency() {
        assertFalse(true);
    }

    @Test(dependsOnMethods = "testDependency")
    public void testSkipped() {
    }

}
