package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Objects;

public class Tree {

    private final String typeOfChange;
    private final String key;
    private final Object startingValue;
    private final Object finalValue;

    public Tree(String type, String thisKey, Object sValue, Object fValue) {
        this.typeOfChange = type;
        this.key = thisKey;
        this.startingValue = sValue;
        this.finalValue = fValue;
    }

    public final String getTypeOfChange() {
        return typeOfChange;
    }

    public final String getKey() {
        return key;
    }

    public final Object getStartingValue() {
        return startingValue;
    }

    public final Object getFinalValue() {
        return finalValue;
    }

    public static List<Tree> buildDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> allKeys = new TreeSet<>();

        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        List<Tree> allDifferences = new ArrayList<>();

        for (String key : allKeys) {
            allDifferences.add(createDifference(map1, map2, key));
        }
        return allDifferences;
    }

    private static Tree createDifference(Map<String, Object> m1, Map<String, Object> m2, String key) {

        Object map1key = m1.get(key);
        Object map2key = m2.get(key);

        if (!m2.containsKey(key)) {
            return new  Tree("removed", key, map1key, map2key);
        } else if (!m1.containsKey(key)) {
            return new Tree("added", key, map1key, map2key);
        } else if (Objects.equals(map1key, map2key)) {
            return new Tree("unchanged", key, map1key, map2key);
        } else {
            return new Tree("changed", key, map1key, map2key);
        }
    }
}
