package ignore_test;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestIgnoreMethod {
    @Test
    @Ignore
    public void test1() {
        System.out.println("test 1");
    }

    @Test
    public void test2() {
        System.out.println("test 2");
    }

    @Test
    public void test3() {
        System.out.println("test 3");
    }
}
