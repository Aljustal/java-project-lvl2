package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;

public class Differ {

    public static String generate(String filepath1, String filepath2, String formatName) throws IOException {
        Map<String, Object> firstFileToMap = getData(filepath1);
        Map<String, Object> secondFileToMap = getData(filepath2);

        List<Tree> diffTree = Tree.buildDiff(firstFileToMap, secondFileToMap);

        return Formatter.format(diffTree, formatName);
    }

    public static String generate(String filepath1, String filepath2) throws IOException {
        return generate(filepath1, filepath2, "stylish");
    }

    private static String getStringFromFile(String filepath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    public static Map<String, Object> getData(String filepath) throws IOException {
        String stringFromFile = getStringFromFile(filepath);
        return Parser.getParse(stringFromFile, filepath);
    }
}
