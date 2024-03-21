package JunitAssignment;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
public class Assignment6 {
//Store the path of the file as string and open the file.
//Open the workbook.
//Open the first worksheet.
//Go to the first row.
//Create a cell on the 3rd column (2nd index) on the first row.
//Write “POPULATION” on that cell.
//Create a cell on the 2nd row 3rd cell(index2), and write data.
//Create a cell on the 3rd row 3rd cell(index2), and write data.
//Create a cell on the 4th row 3rd cell(index2), and write data.
//Write and save the workbook.
//Close the file.
//Close the workbook.
//The 3rd column on excel file must be empty before running.
// Otherwise, new data will be written on the old data
 private final String filePath = "C://Users//noufz//IdeaProjects//SDA-Assigment//src//test//resources//Assignment6.xlsx";

        @Test
        public void junitAssignment6() throws IOException {
            // Store the path of the file as a string and open the file
            FileInputStream file = new FileInputStream(filePath);

            // Open the workbook
            Workbook workbook = new XSSFWorkbook(file);

            // Open the first worksheet
            Sheet sheet = workbook.getSheetAt(0);

            // Go to the first row
            Row row = sheet.getRow(0);
            if (row == null) {
                row = sheet.createRow(0);
            }

            // Create a cell on the 3rd column (2nd index) on the first row
            Cell cell = row.createCell(2);

            // Write "POPULATION" on that cell
            cell.setCellValue("POPULATION");

            // Create cells on the 2nd, 3rd, and 4th rows, 3rd cell (index 2), and write data
            sheet.getRow(2).createCell(2).setCellValue(400000);
            sheet.getRow(3).createCell(2).setCellValue(500000);
            sheet.getRow(4).createCell(2).setCellValue(600000);


            // Write and save the workbook
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            // Close the file
            file.close();

            // Close the workbook
            workbook.close();

            // Verify the changes by reading the file again
            FileInputStream fileVerify = new FileInputStream(filePath);
            Workbook workbookVerify = new XSSFWorkbook(fileVerify);
            Sheet sheetVerify = workbookVerify.getSheetAt(0);
            Row rowVerify = sheetVerify.getRow(0);
            Cell cellVerify = rowVerify.getCell(2);
            assertEquals("POPULATION", cellVerify.getStringCellValue());
            workbookVerify.close();
            fileVerify.close();
        }

}
