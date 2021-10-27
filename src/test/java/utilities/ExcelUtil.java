package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    private Workbook workbook;
    private Sheet sheet;
    private String path;

    public ExcelUtil(String filePath, String sheetName) {

        path = filePath;

        try {

            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);
            Assert.assertNotNull(sheet, "Worksheet " + sheetName + " was not found!");

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    //============ Tablodaki Toplam Sutun Sayisini Alma (Index degil!) ============//

    public int getNumberOfColumns() {

        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    //============ Tablodaki Toplam Satir Sayisini Alma (Index degil!) ============//

    public int getNumberOfRows() {

        return sheet.getLastRowNum() + 1;
    }

    //============ Tabloda Kullanilan Satir Sayisini Alma ============//

    public int getNumberOfUsedRows() {

        return sheet.getPhysicalNumberOfRows();
    }

    //============ Istenen Satirdaki  Datalari Alma (Index degil!) ============//

    public List<String> getElementsAtTheRow(int rowNumber) {

        List<String> allDataAtTheRow = new ArrayList<>();

        for (int i = 0; i < getNumberOfColumns(); i++) {

            try {
                allDataAtTheRow.add(sheet.getRow(rowNumber - 1).getCell(i).toString());
            } catch (NullPointerException e) {
                allDataAtTheRow.add(" ");
            }
        }
        return allDataAtTheRow;
    }

    //============ Satir ve Sutun Girerek Datayi Alma (Index degil!) ============//

    public String getCellData(int row, int cell) {

        String cellValue = "";


        try {
            cellValue = sheet.getRow(row - 1).getCell(cell - 1).toString();
        } catch (NullPointerException e) {
            cellValue = " ";
        }
        return cellValue;
    }

    //============ Datalari Multi Dimensional Array Seklinde Almak (Index degil!) ============//

    public String[][] getAllDataAsArray() {

        String arr[][] = new String[getNumberOfRows()][getNumberOfColumns()];

        for (int i = 1; i <= getNumberOfRows(); i++) {

            for (int j = 1; j <= getNumberOfColumns(); j++) {

                String value = getCellData(i, j);
                arr[i - 1][j - 1] = value;
            }
        }
        return arr;
    }

    //============ Datalari Map Seklinde Almak (Index degil!) ============//

    public Map<String, String> getDataAsMap() {

        Map<String, String> allData = new LinkedHashMap<>();
        String key = "";
        String value = "";

        for (int i = 1; i <= getNumberOfRows(); i++) {
            key = getElementsAtTheRow(i).get(0);
            value = "";
            for (int j = 1; j < getElementsAtTheRow(i).size(); j++) {
                value += " " + getElementsAtTheRow(i).get(j);
            }
            allData.put(key, value);
        }

        return allData;
    }

    //============ Tabloya Data Girmek ve Guncellemek (Index degil!) ============//

    public void setCellData(int row, int cell, String value) {

        if (sheet.getRow(row - 1).getCell(cell - 1) == null) {
            sheet.getRow(row - 1).createCell(cell - 1).setCellValue(value);
        } else {
            sheet.getRow(row - 1).getCell(cell - 1).setCellValue(value);
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            System.err.println("There is a problem about file path or write function!");
        }
    }
}