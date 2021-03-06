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
    writeReportFilePage writeReportFilePage;
    WebDriver driver;
    //https://www.youtube.com/watch?v=0yBJseqPM-w
    public ReadExcelPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ReadExcelDateAndCreateCoursesLessons() throws IOException, CsvValidationException {
        coursesPage = new CoursesPage(getDriver());
        createNewCoursePage = new CreateNewCoursePage(getDriver());
        createLessonPage = new CreateLessonPage(getDriver());
        writeReportFilePage = new writeReportFilePage();
        String failedRow="Failed row: ";
        String failedData="Course Name,Course Advisor,Course Tag,Course Date,Lesson Number,Lesson Start Date,Lesson Start Time,Duration,Week's Law,Teacher,Lesson Tag\n";
        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\thang.phan\\Desktop\\test.csv"));
        String csvCell[];

        int firstLine =0;
        int printOutLine = firstLine+1;
        while((csvCell=reader.readNext())!= null)
        {
            //Skip title row
            if(firstLine==0)
            {
                firstLine++;
                printOutLine++;
                continue;
            }
            //Get Data
            String courseName = csvCell[0].trim();
            String courseAdvisor = csvCell[1].trim();
            String courseTag = csvCell[2].trim();
            String courseDate = csvCell[3].trim();
            String lessonNumber = csvCell[4].trim();
            String lessonStartDate = csvCell[5].trim();
            //Get hour and minute of Lesson Start Time
            String lessonStartTime = csvCell[6].trim();
            String[] lessonStartTimeParts=lessonStartTime.split("\\:");
            String lessonStartTimeHour = lessonStartTimeParts[0];
            String lessonStartTimeMinute = lessonStartTimeParts[1];
            //Get hour and minute of Lesson Duration
            String lessonDuration = csvCell[7].trim();
            String[] lessonDurationParts=lessonDuration.split("\\:");
            String lessonDurationHour = lessonDurationParts[0];
            String lessonDurationMinute = lessonDurationParts[1];
            //
            String lessonWeeksLaw = csvCell[8].trim();
            String lessonTeacher = csvCell[9].trim();
            String lessonTag = csvCell[10].trim();
            // Create new course
            coursesPage.clickCreateCourse();
            if(createNewCoursePage.createNewCourse(courseName,courseDate,courseTag,courseAdvisor)==false)
            {
                System.out.println("Failed to create course at row: "+printOutLine+"\n");
                failedRow=failedRow+printOutLine+", ";
                createLessonPage.switchToFirstTab();//If create current course failed. Go back to first tab to create next course
                printOutLine++;
                failedData=failedData+courseName+","+courseAdvisor+","+courseTag+","+courseDate+","+lessonNumber+","+lessonStartDate+","+lessonStartTime+","+lessonDuration+","+lessonWeeksLaw+","+lessonTeacher+","+lessonTag+"\n";
                continue;
            }
            else
                System.out.println("Created course at row: "+printOutLine+"\n");
            ////////////////////createNewCoursePage.goToLessonPage(); => Turn this on to test lesson with no create course
            //Create new lesson
            if(createLessonPage.createLesson(lessonStartDate,lessonTag,lessonWeeksLaw,lessonNumber,lessonStartTimeHour,lessonStartTimeMinute,lessonDurationHour,lessonDurationMinute,lessonTeacher,courseDate)==false)
            {
                System.out.println("Failed to create the lesson/course at row: "+printOutLine+"\n");
                failedRow=failedRow+printOutLine+", ";
                createLessonPage.switchToFirstTab();//If create lesson of current course failed. Go back to first tab to create next course
                printOutLine++;
                failedData=failedData+courseName+","+courseAdvisor+","+courseTag+","+courseDate+","+lessonNumber+","+lessonStartDate+","+lessonStartTime+","+lessonDuration+","+lessonWeeksLaw+","+lessonTeacher+","+lessonTag+"\n";
                continue;
            }
            else
                System.out.println("Created lesson at row: "+printOutLine+"\n");
            printOutLine++;
        }
        System.out.println(failedRow);
        writeReportFilePage.writeReportFile(failedRow,failedData);
    }
}
