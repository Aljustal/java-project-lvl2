package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;

public class AppTest {
    @Test
    void testGenDiffJSON() throws Exception {

        String filepath1 = ("src/test/resources/file1.json");
        String filepath2 = ("src/test/resources/file2.json");
        String stylishJSON = ("src/test/resources/fixtures/stylishJSON");

        String expectedString = Files.readString(Paths.get(stylishJSON));

        String actual = Differ.generate(filepath1, filepath2);
        assertThat(actual).isEqualTo(expectedString);
    }

    @Test
    void testGenDiffYML() throws Exception {

        String filepath1 = ("src/test/resources/file1.yml");
        String filepath2 = ("src/test/resources/file2.yml");
        String stylishYML = ("src/test/resources/fixtures/stylishYML");

        String expectedString = Files.readString(Paths.get(stylishYML));

        String actual = Differ.generate(filepath1, filepath2);
        assertThat(actual).isEqualTo(expectedString);
    }
}