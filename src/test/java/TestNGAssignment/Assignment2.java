package TestNGAssignment;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.testng.Tests;

import java.io.FileInputStream;
import java.io.IOException;

public class Assignment2 extends Tests {
    /*
Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
Add 10 notes using data provider with excel
Run it with 3 different browsers using XML file
Run it parallel with 3 threads
 */

    @Test(dataProvider = "data-provider")
    public void Assignment2(String title, String note) {

        bot.navigate("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");

        By titleLocator = By.id("note-title-input");
        By notesLocator = By.id("note-details-input");
        By submitLocator = By.id("add-note");
        By listLocator = By.className("note-in-list");

        bot.type(titleLocator, title);
        bot.type(notesLocator, note);
        bot.click(submitLocator);

        boolean check = driver.findElement(listLocator).isDisplayed();
        System.out.println("The list of notes is displayed: " + check);
        Assert.assertTrue(check);
    }

    @DataProvider(name = "data-provider")
    public Object[][] getData() throws IOException {
        Object[][] data = new Object[10][2];
        String path = "C://Users//noufz//IdeaProjects//SDA-Assigment//src//test//resources//Assignment6.xlsx";
        Workbook workbook = new XSSFWorkbook(new FileInputStream(path));
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < 10; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                data[i][0] = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
                data[i][1] = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
            } else {
                data[i][0] = "";
                data[i][1] = "";
            }
        }

        return data;
        //Doing Cross Browser Testing.
        /* - **Check Assignment2.xml file** - */
    }
}