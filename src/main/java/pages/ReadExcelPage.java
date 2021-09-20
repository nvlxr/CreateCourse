package pages;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.WebDriver;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static driver.HookSteps.getDriver;
public class ReadExcelPage {
    CoursesPage coursesPage;
    CreateNewCoursePage createNewCoursePage;
    CreateLessonPage createLessonPage;
    WebDriver driver;
    //https://www.youtube.com/watch?v=0yBJseqPM-w
    public ReadExcelPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ReadExcelDateAndCreateCoursesLessons() throws IOException, CsvValidationException {
        coursesPage = new CoursesPage(getDriver());
        createNewCoursePage = new CreateNewCoursePage(getDriver());
        createLessonPage = new CreateLessonPage(getDriver());
        CSVReader reader = new CSVReader(new FileReader("C://test.csv"));
        String csvCell[];
        int currentLine = 0;
        while((csvCell=reader.readNext())!= null)
        {
            //Skip title row
            if(currentLine==0)
            {
                currentLine++;
                continue;
            }
            //Get Data
            String courseName = csvCell[0];
            String courseAdvisor = csvCell[1];
            String courseTag = csvCell[2];
            String courseDate = csvCell[3];
            String lessonNumber = csvCell[4];
            String lessonStartDate = csvCell[5];
            //Get hour and minute of Lesson Start Time
            String lessonStartTime = csvCell[6];
            String[] lessonStartTimeParts=lessonStartTime.split("\\:");
            String lessonStartTimeHour = lessonStartTimeParts[0];
            String lessonStartTimeMinute = lessonStartTimeParts[1];
            //Get hour and minute of Lesson Duration
            String lessonDuration = csvCell[7];
            String[] lessonDurationParts=lessonDuration.split("\\:");
            String lessonDurationHour = lessonDurationParts[0];
            String lessonDurationMinute = lessonDurationParts[1];
            //
            String lessonWeeksLaw = csvCell[8];
            String lessonTeacher = csvCell[9];
            String lessonTag = csvCell[10];
            // Create new course
            coursesPage.clickCreateCourse();
            createNewCoursePage.createNewCourse(courseName,courseDate,courseTag,courseAdvisor);
            createNewCoursePage.goToLessonPage();
            //Create new lesson
            createLessonPage.createLesson(lessonStartDate,lessonTag,lessonWeeksLaw,lessonNumber,lessonStartTimeHour,lessonStartTimeMinute,lessonDurationHour,lessonDurationMinute,lessonTeacher);
            System.out.println("Done course no.: "+currentLine+"\n");
        }
    }
}
