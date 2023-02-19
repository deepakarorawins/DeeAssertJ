package deesite.deetests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTests {

    @Test
    public void fileTest(){
        Path expectedFile = Paths.get("src/test/resources/data/actualFile");
        Path actualFile = Paths.get("src/test/resources/data/expectedFile");

        Assertions.assertThat(actualFile).hasSameTextualContentAs(expectedFile);
    }
}
