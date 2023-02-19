package deesite.deetests;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class ListTests {

    @Test(dataProvider = "getData")
    public void listTest(List<String> input){
        List<String> expected = Arrays.asList("apple", "banana");
        Assertions.assertThat(input)
                .hasSize(3)
                .doesNotContain("cat")
                .containsAll(expected)
                .allSatisfy(s -> Assertions.assertThat(s.length()).isGreaterThanOrEqualTo(4));
    }

    @Test(dataProvider = "getData")
    public void softListTest(List<String> input){
        List<String> expected = Arrays.asList("apple", "banana");
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(input)
                    .hasSize(3)
                    .doesNotContain("cat")
                    .containsAll(expected)
                    .allSatisfy(s->softAssertions.assertThat(s.length()).isGreaterThanOrEqualTo(4));
        });
    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                Arrays.asList("banana", "apple", "car")
        };
    }
}
