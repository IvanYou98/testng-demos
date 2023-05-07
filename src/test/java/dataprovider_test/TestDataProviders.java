package dataprovider_test;

import org.testng.annotations.Test;

import java.util.Arrays;

public class TestDataProviders {
    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "dataFromArray")
    public void testDataProviderFromArray(Object[] row) {
        System.out.println(Arrays.toString(row));
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "dataFromDB")
    public void testDataProviderFromDB(Object[] row) {
        System.out.println(Arrays.toString(row));
    }

    @Test(dataProviderClass = DataProviders.class,
            dataProvider = "dataFromExcel")
    public void testDataFromExcel(Object[] row) {
        System.out.println(Arrays.toString(row));
    }

}
