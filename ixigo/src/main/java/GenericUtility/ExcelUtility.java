package GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	Workbook wb;
    Sheet sh;

  
   public void loadExcelFile(String filepath, String sheetName)
           throws EncryptedDocumentException, IOException {

       FileInputStream fis = new FileInputStream(filepath);
       wb = WorkbookFactory.create(fis);
       sh = wb.getSheet(sheetName);

       if (sh == null) {
           throw new RuntimeException("Sheet not found: " + sheetName);
       }
   }

  
   public String getDataFromSingleCell(int rowNum, int cellNum) {

       if (sh == null) {
           throw new RuntimeException("Excel not loaded. Call loadExcelFile() first.");
       }

       Row row = sh.getRow(rowNum);
       if (row == null) return "";

       Cell cell = row.getCell(cellNum);
       if (cell == null) return "";

       switch (cell.getCellType()) {

           case STRING:
               return cell.getStringCellValue();

           case NUMERIC:
               double num = cell.getNumericCellValue();
               return (num % 1 == 0)
                       ? String.valueOf((int) num)
                       : String.valueOf(num);

           case BOOLEAN:
               return String.valueOf(cell.getBooleanCellValue());

           case BLANK:
               return "";

           default:
               return "";
       }
   }

   public String[] getSingleRowData(int rowNum) {

       if (sh == null) {
           throw new RuntimeException("Excel not loaded. Call loadExcelFile() first.");
       }

       Row row = sh.getRow(rowNum);
       if (row == null) return new String[0];

       int colCount = row.getLastCellNum();
       String[] data = new String[colCount];

       for (int i = 0; i < colCount; i++) {
           data[i] = getDataFromSingleCell(rowNum, i);
       }

       return data;
   }

   public void writeDataIntheCell(String filepath, String sheetName,
                                 int rowNum, int cellNum, String data)
           throws EncryptedDocumentException, IOException {

       FileInputStream fis = new FileInputStream(filepath);
       Workbook wb = WorkbookFactory.create(fis);
       Sheet sheet = wb.getSheet(sheetName);

       if (sheet == null) {
           sheet = wb.createSheet(sheetName);
       }

       Row row = sheet.getRow(rowNum);
       if (row == null) row = sheet.createRow(rowNum);

       Cell cell = row.getCell(cellNum);
       if (cell == null) cell = row.createCell(cellNum);

       cell.setCellValue(data);

       FileOutputStream fos = new FileOutputStream(filepath);
       wb.write(fos);

       fos.close();
       wb.close();
   }

   public void closeWorkbook() throws IOException {
       if (wb != null) {
           wb.close();
       }
   }
}
