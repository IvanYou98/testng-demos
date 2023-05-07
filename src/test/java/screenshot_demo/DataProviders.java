package screenshot_demo;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(parallel = true)
    public static Object[][] userCredentialsProvider() {
        return new Object[][]{
                {"Admin", "admin123"},
                {"test", "test123"}
        };
    }
}
