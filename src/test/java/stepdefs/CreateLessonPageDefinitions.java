package stepdefs;
import cucumber.api.java.en.Then;
import pages.CreateLessonPage;
import static driver.HookSteps.getDriver;
public class CreateLessonPageDefinitions {
    CreateLessonPage createLessonPage;
    @Then("^I create lesson")
    public void i_create_lesson()
    {
        createLessonPage = new CreateLessonPage(getDriver());
        createLessonPage.createLesson( "2022-10-30","pRoduction","1234567","2","23","55","2","20","tung");
        System.out.println("Create lesson successfully");
    }
}
