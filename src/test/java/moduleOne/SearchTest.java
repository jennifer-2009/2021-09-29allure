package moduleOne;


import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
    @Description("This is my first allure test...")
    @Test
    public void searchCourse(){

        System.out.println(getInt()+".........test");
    }
    @Step("this is the first allure step")
    private int getInt(){

        return 11;
    }
}
