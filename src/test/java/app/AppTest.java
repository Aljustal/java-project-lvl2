package app;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppTest {
    @Test
    void testDiffJSON() throws Exception {

        String filepath1 = ("src/test/resources/file1.json");
        String filepath2 = ("src/test/resources/file2.json");
        String stylishJSON = ("src/test/resources/fixtures/stylishJSON");

        String expectedString = Files.readString(Paths.get(stylishJSON));

        String actual = Differ.generate(filepath1, filepath2);
        assertThat(actual).isEqualTo(expectedString);
    }

    @Test
    void testDiffYML() throws Exception {

        String filepath1 = ("src/test/resources/file1.yml");
        String filepath2 = ("src/test/resources/file2.yml");
        String stylishYML = ("src/test/resources/fixtures/stylishYML");
        String ymlPlainFormat = ("src/test/resources/fixtures/yml");

        String expectedString = Files.readString(
                Paths.get(stylishYML));

        String expectedStringPlainFormat = Files.readString(
                Paths.get(ymlPlainFormat));

        String actual = Differ.generate(filepath1, filepath2);
        assertThat(actual).isEqualTo(expectedString);

        String actualPlainFormat = Differ.generate(filepath1, filepath2, "plain");
        assertThat(actualPlainFormat).isEqualTo(expectedStringPlainFormat);
    }

    @Test
    void testDiffPlain() throws Exception {

        String filepath1 = ("src/test/resources/file_1.json");
        String filepath2 = ("src/test/resources/file_2.json");
        String plain = ("src/test/resources/fixtures/plain");

        String expectedString = Files.readString(
                Paths.get(plain));

        String actual = Differ.generate(filepath1, filepath2, "plain");
        assertThat(actual).isEqualTo(expectedString);
    }
    @Test
    void testOutputAsJSON() throws Exception {
        String filepath1 = ("src/test/resources/file1.json");
        String filepath2 = ("src/test/resources/file2.json");
        String json = "src/test/resources/fixtures/json";

        String expectedString = Files.readString(
                Paths.get(json));

        String result = Differ.generate(filepath1, filepath2, "json");
        assertThat(result).isEqualTo(expectedString);
    }
}
