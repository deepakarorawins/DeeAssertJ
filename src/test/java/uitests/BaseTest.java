package uitests;

import assertions.PageAssert;
import assertions.WebElementAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.BasePage;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }

    protected WebElementAssert assertThat(WebElement element){
        return WebElementAssert.assertThat(element);
    }

    protected PageAssert assertThat(BasePage basePage){
        return PageAssert.assertThat(basePage);
    }
}
