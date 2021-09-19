package pages;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.WebDriver;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class ReadExcelPage {
    WebDriver driver;
    //https://www.youtube.com/watch?v=0yBJseqPM-w
    public ReadExcelPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ReadExcelFile() throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader("C://test.csv"));
        String csvCell[];
        while((csvCell=reader.readNext())!= null)
        {
            String CourseName = csvCell[0];
            String Advisor = csvCell[1];

        }
    }
}
