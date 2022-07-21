package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String format(List<Tree> diffTree, String formatName) throws JsonProcessingException {
        if (formatName.equals("plain")) {
            return Plain.formatter(diffTree);
        } else if (formatName.equals("json")) {
            return Json.formatter(diffTree);
        }
        return Stylish.formatter(diffTree);
    }
}
