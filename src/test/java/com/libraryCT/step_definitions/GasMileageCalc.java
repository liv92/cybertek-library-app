package com.libraryCT.step_definitions;

import com.libraryCT.pages.CalculatorNetPage;
import com.libraryCT.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GasMileageCalc {

    CalculatorNetPage calculatorNetPage = new CalculatorNetPage();

    @Test
    public void gas_mileage_calc() throws IOException {

        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");

        String path = "src/test/resources/excelData/Data1.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("CalcData");

        for(int rowNum = 1; rowNum<=sheet.getLastRowNum(); rowNum++) {

            XSSFRow row = sheet.getRow(rowNum);

            calculatorNetPage.currentOdomReading.clear();
            double current = Double.parseDouble(row.getCell(1).toString());
            calculatorNetPage.currentOdomReading.sendKeys(String.valueOf(current));

            calculatorNetPage.previousOdomReading.clear();
            double previous = Double.parseDouble(row.getCell(2).toString());
            calculatorNetPage.previousOdomReading.sendKeys(String.valueOf(previous));

            calculatorNetPage.gasTank.clear();
            double gas = Double.parseDouble(row.getCell(3).toString());
            calculatorNetPage.gasTank.sendKeys(String.valueOf(gas));

            calculatorNetPage.calculateButton.click();

            double expectedMpg = (current - previous) / gas;

            DecimalFormat df = expectedMpg % 2 == 0 ? new DecimalFormat("00") : new DecimalFormat("00.00");

            String expected = df.format(expectedMpg);
            String actual = calculatorNetPage.gasMileage.getText().split(" ")[0];

            row.createCell(4);
            row.getCell(4).setCellValue(expected);
            row.createCell(5);
            row.getCell(5).setCellValue(actual);

            row.createCell(6);

            if(expected.equals(actual)){
                row.getCell(6).setCellValue("PASS");
            }else{
                row.getCell(6).setCellValue("FAIL");
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
            row.createCell(7);
            row.getCell(7).setCellValue(LocalDateTime.now().format(dtf));

        }

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        Driver.closeDriver();

    }


}
