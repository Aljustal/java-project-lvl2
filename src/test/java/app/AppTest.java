package app;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        String expectedJson = ("src/test/resources/expectedJson.json");
        String actual = "{\"- follow\":false,\"host\":\"hexlet.io\",\"- proxy\":\"123.234.53.22\",\"- timeout\":50,\"+ timeout\":20,\"+ verbose\":true}";

        String expectedString = Files.readString(Paths.get(expectedJson));

        String result = Differ.generate(filepath1, filepath2);

        ObjectMapper mapper = new ObjectMapper();
        String jsonAsString = mapper.writeValueAsString(expectedString);

        assertThat(result).isEqualTo(actual);
    }

}
