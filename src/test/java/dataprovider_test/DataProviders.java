package dataprovider_test;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public static Object[][] dataFromArray() {
        return new Object[][]{{"admin", "admin123"},
                {"guest", "guest123"}};
    }

    @DataProvider
    public static Iterator<Object[]> dataFromDB() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from product_table");
        List<Object[]> data = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            data.add(new Object[]{name, price});
        }
        return data.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> dataFromExcel() throws IOException, InvalidFormatException {
        Workbook workbook = new XSSFWorkbook(new File("src/test/resources/excel_files/accounts.xlsx"));
        List<Object[]> rows = new ArrayList<>();
        Iterator<Row> it = workbook.getSheet("sheet1").iterator();
        // skip the first row
        it.next();
        it.forEachRemaining(row -> rows.add(new Object[]{
                row.getCell(0),
                row.getCell(1)})
        );
        return rows.iterator();
    }

    @DataProvider(parallel = true)
    public static Object[][] parallelDataSource() {
        return new Object[50][2];
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
}
