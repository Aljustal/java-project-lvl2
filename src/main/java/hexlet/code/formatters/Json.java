package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Tree;

import java.util.List;

public class Json {
    public static String formatter(List<Tree> diffTree) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(diffTree);
    }
}
