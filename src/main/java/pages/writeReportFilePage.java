package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class writeReportFilePage {

public void writeReportFile(String failedCourse,String failedData)
{
    try {
        File file = new File("C:\\Users\\thang.phan\\Desktop\\CreateCoursesReport.csv");
        //file.mkdirs();
        if(!file.exists()){

            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);

        fw.write(failedCourse);
        fw.write("\n");
        fw.write(failedData);

        fw.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
