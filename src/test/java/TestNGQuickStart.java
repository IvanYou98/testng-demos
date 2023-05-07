import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestNGQuickStart {
    private int sum(int a, int b) {
        return a + b + 1;
    }

    @Test
    public void testHardAssertion() {
        assertEquals(sum(1, 2), 1 + 2, "The output of sum is not correct!");
        System.out.println("Yes I am!");
    }
}
