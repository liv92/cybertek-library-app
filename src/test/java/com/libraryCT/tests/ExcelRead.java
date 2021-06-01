package com.libraryCT.tests;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {


    @Test
    public void excel_read_test() throws IOException {

        String path = "SampleData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook > sheet > row > cell

        //workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //sheet
        XSSFSheet sheet = workbook.getSheet("Employees");

        //row -> cell
        System.out.println(sheet.getRow(1).getCell(0));
        System.out.println(sheet.getRow(3).getCell(2));

        //returns the count of used cells only, if there are cells not used they will not be counted. count starts from 1
        int usedRows = sheet.getPhysicalNumberOfRows();

        //returns count from top to bottom, even if counts if there are empty cells, starts count from 0
        int lastUsedRow = sheet.getLastRowNum();

        //TODO: CREATE A LOGIC TO PRINT OUT NEENA'S NAME DYNAMICALLY
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Neena")){
                System.out.println("CurrentCell = "+sheet.getRow(rowNum).getCell(0));
            }
        }

        //TODO: CREATE A LOGIC TO PRINT OUT SANDLER LAST NAME DYNAMICALLY
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(1).toString().equals("Sandler")){
                System.out.println("CurrentCell = "+sheet.getRow(rowNum).getCell(1));
            }
        }

        //TODO: CREATE A LOGIC TO PRINT OUT STEVEN KING JOB_ID DYNAMICALLY, CHECK FOR LAST NAME~
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(1).toString().equals("King")){
                System.out.println("Steven King JOB_ID = "+sheet.getRow(rowNum).getCell(2));
            }
        }


    }

}
