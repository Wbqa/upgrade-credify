package com.upgrade.automation.common.test.dataprovider;

import com.upgrade.automation.common.ExcelReader;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class ExcelDataProvider {

    @DataProvider(name="user_data_dp")
    public Object[][] getData(Method m) throws Exception {
        String xlFile = "/data/excel/testdata.xlsx";
    	String sheetName = m.getName();
    	
        ExcelReader xlReader = ExcelReader.loadData(xlFile);
        int rows = xlReader.getRowCount(sheetName);
        int cols = xlReader.getColumnCount(sheetName);
        Object[][] data = new Object[rows - 1][1];
        Hashtable<String, String> table = null;

        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            table = new Hashtable<String, String>();
            for (int colNum = 0; colNum < cols; colNum++) {
                table.put(xlReader.getCellData(sheetName, colNum, 1), xlReader.getCellData(sheetName, colNum, rowNum));
                data[rowNum - 2][0] = table;
            }
        }

        return data;
    }
}



