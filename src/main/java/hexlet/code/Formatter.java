package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String format(List<Tree> diffTree, String formatName) throws JsonProcessingException {
        switch (formatName) {
            case "plain":
                return Plain.getPlainFormatter(diffTree);
            case "json":
                return Json.getJsonFormatter(diffTree);
            default:
                return Stylish.getStylishFormatter(diffTree);
        }
    }
}
