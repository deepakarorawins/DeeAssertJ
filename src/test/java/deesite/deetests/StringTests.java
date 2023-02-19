package deesite.deetests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
public class StringTests {

    @Test(dataProvider = "getData")
    public void stringTest(String input){
        Assertions.assertThat(input)
                .hasSize(8)
                .startsWith("Se")
                .doesNotContain("api")
                .doesNotContainAnyWhitespaces()
                .containsOnlyOnce("i");
    }

    @Test(dataProvider = "getData")
    public void softStringTest(String input){
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(input)
                    .hasSize(8)
                    .startsWith("Se")
                    .doesNotContain("api")
                    .doesNotContainAnyWhitespaces()
                    .containsOnlyOnce("i");
        });

    }

    @DataProvider
    public Object[] getData(){
        return new String[] {
                "Selenium",
                "Selenide",
                "restapi"
        };
    }
}
