package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {

    public String[][] readExcelFile (String fileName, int sheetIndex) throws IOException {
        String[][] tabArray = null;
        File excelFile = new File(fileName);
        FileInputStream fis = new FileInputStream(excelFile);

        // we create an XSSF Workbook object for our XLSX Excel File
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // we get first sheet
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
        int totalRows = sheet.getLastRowNum();
        int totalCols = 2;
        tabArray=new String[totalRows][totalCols];

        // we iterate on rows
        Iterator<Row> rowIt = sheet.iterator();
        int rowCount = 0;
        while(rowIt.hasNext()) {
            Row row = rowIt.next();

            // iterate on cells for the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            int colCount = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                tabArray[rowCount][colCount] = cell.toString();
                colCount +=1;
                System.out.println(tabArray.toString());
            }
            rowCount += 1;
            if(rowCount == totalRows) break;
        }

        workbook.close();
        fis.close();
        return tabArray;
    }
}