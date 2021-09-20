package stepdefs;
import com.opencsv.exceptions.CsvValidationException;
import pages.ReadExcelPage;
import cucumber.api.java.en.Then;

import java.io.IOException;

import static driver.HookSteps.getDriver;

public class ReadExcelFileDefinitions {
    ReadExcelPage readExcelPage;

    @Then("^I read excel data and create courses and lessons$")
    public void i_read_excel_data_n_create_courses_lessons() throws CsvValidationException, IOException {
        readExcelPage=new ReadExcelPage(getDriver());
        readExcelPage.ReadExcelDateAndCreateCoursesLessons();
    }
}
