package group_test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestGroups {

    @AfterMethod(groups = "common")
    public void printDivider() {
        System.out.println("===============");
    }

    @Test(groups = {"smoke"})
    public void smokeTest1() {
        System.out.println("smoke test 1");
    }

    @Test(groups = {"smoke", "regression"})
    public void smokeAndRegressionTest1() {
        System.out.println("smoke and regression test 1");
    }

    @Test(groups = {"regression"})
    public void regressionTest1() {
        System.out.println("regression test 1");
    }

    @Test(groups = {"other"})
    public void otherTest() {
        System.out.println("other test");
    }

}
