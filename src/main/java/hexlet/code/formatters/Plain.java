package hexlet.code.formatters;

import hexlet.code.Tree;
import java.util.List;

public class Plain {

    public static String getPlainFormatter(List<Tree> diffTree) {
        StringBuilder diffBuilder = new StringBuilder();

        for (Tree pair : diffTree) {
            String key = pair.getKey();
            Object sValue = pair.getStartingValue();
            Object fValue = pair.getFinalValue();
            String typeOfChange = pair.getTypeOfChange();

            String thisKey = "Property '" + key + "'";

            switch (typeOfChange) {

                case "removed":
                    diffBuilder.append(thisKey + " was removed" + "\n");
                    break;

                case "added":
                    diffBuilder.append(thisKey + " was added with value: " + getValueAsString(fValue) + "\n");
                    break;

                case "changed":
                    diffBuilder.append(thisKey + " was updated. From " + getValueAsString(sValue)
                            + " to " + getValueAsString(fValue) + "\n");
                    break;

                default:
                    break;
            }
        }
        return diffBuilder.toString().trim();
    }

    private static String getValueAsString(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value == null) {
            return "null";
        } else if (!(value instanceof Integer) && !(value instanceof Boolean)) {
            return "[complex value]";
        }
        return value.toString();
    }
}

