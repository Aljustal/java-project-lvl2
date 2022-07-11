package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map1 = mapper.readValue(Paths.get(filepath1).toFile(), Map.class);
        Map<String, Object> map2 = mapper.readValue(new File(filepath2), Map.class);


        Set<String> uniqKeys = new HashSet<>();
        uniqKeys.addAll(map1.keySet());
        uniqKeys.addAll(map2.keySet());

        List<String> sortedUniqKeys = new ArrayList<>(uniqKeys);
        Collections.sort(sortedUniqKeys);

        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();

        for (var el: sortedUniqKeys) {
            var map1Val = map1.getOrDefault(el, null);
            var map2Val = map2.getOrDefault(el, null);

            if (map1Val == null) {
                resultMap.put("+ " + el, map2Val);
            } else if (map1Val.equals(map2Val)) {
                resultMap.put(el.toString(), map1Val);
            } else if (map2Val == null) {
                resultMap.put("- " + el, map1Val);
            } else {
                resultMap.put("- " + el, map1Val);
                resultMap.put("+ " + el, map2Val);
            }
        }

        String jsonAsString = mapper.writeValueAsString(resultMap);

        return jsonAsString;
    }
}
