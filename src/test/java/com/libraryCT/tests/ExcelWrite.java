package com.libraryCT.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    @Test
    public void excel_write_test() throws IOException {

        String path = "SampleData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook > sheet > row > cell

        workbook = new XSSFWorkbook(fileInputStream);

        sheet = workbook.getSheet("Employees");

        //kings row
        row = sheet.getRow(1);

        //kings cell
        cell = row.getCell(1);

        //EX: Storing Adam's name cell if we were to be re-using it
        XSSFCell adamsCell = sheet.getRow(2).getCell(0);
        System.out.println("Before = "+adamsCell);
        adamsCell.setCellValue("Madam");
        System.out.println("After = "+adamsCell);
        //===============================================================
        
        //TODO: Change Stevens name to Tom~

        //static way
//        XSSFCell stevensCell = sheet.getRow(1).getCell(0);
//        stevensCell.setCellValue("Tom");
//        System.out.println("stevensCell = " + stevensCell);

        //Dynamic way
        for(int rowNum = 0; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++){

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Steven")){
                sheet.getRow(rowNum).getCell(0).setCellValue("Tom");

            }

        }




        //===============================================================
        //Load the file to outputStream
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        //Write to the file using workbook object
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }

}
