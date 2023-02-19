package uitests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends BaseTest{

    private SearchPage searchPage;

    @BeforeTest
    public void pageSetUp(){
        this.searchPage = new SearchPage(driver);
    }

    @Test
    public void launchSite(){
        this.searchPage.goTo();
        assertThat(this.searchPage).isAt();
    }

    @Test(dependsOnMethods = "launchSite")
    public void keywordTest(){
        this.searchPage.search("dee");
        assertThat(this.searchPage.getSearchBox())
                .isEnabled()
                .isDisplayed()
                .hasAttributeValue("value", "dee1");
    }
}
