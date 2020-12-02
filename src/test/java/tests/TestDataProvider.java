package tests;

import org.testng.annotations.DataProvider;
import util.ConfigFileReader;
import util.ExcelFileReader;

import java.io.IOException;

public class TestDataProvider {

    @DataProvider(name = "login-data")
    public Object[][] dpMethod() throws IOException {
        ConfigFileReader config = new ConfigFileReader();
        String testDataFilePath = System.getProperty("user.dir")+"/" +
                config.getPropertyValue("testdatapath");

        ExcelFileReader excelReader = new ExcelFileReader();
        Object[][] testData = excelReader.readExcelFile(testDataFilePath, 0);
        return testData;
//        return new Object[][] {
//                {"mytest123@gmail.com", "mytest123"},
//                {"mytest123@gmail.com", "mytest123"},
//                {"mytest123@gmail.com", "mytest123"},
//        };
    }
}
