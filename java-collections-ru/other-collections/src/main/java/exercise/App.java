package exercise;

import java.util.*;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff (Map<String, Object> dataOne, Map<String, Object> dataTwo) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        Set<String> dataKeys = new LinkedHashSet<>();
        dataKeys.addAll(dataOne.keySet());
        dataKeys.addAll(dataTwo.keySet());

        for (String key : dataKeys) {
            if (dataOne.containsKey(key) && dataTwo.containsKey(key)) {
                Object dataOneValue = dataOne.get(key);
                Object dataTwoValue = dataTwo.get(key);
                if (dataOneValue.equals(dataTwoValue)) {
                    result.put(key, "unchanged");
                } else {
                    result.put(key, "changed");
                }
            } else if (!dataOne.containsKey(key) && dataTwo.containsKey(key)) {
                result.put(key, "added");
            } else if (dataOne.containsKey(key) && !dataTwo.containsKey(key)) {
                result.put(key, "deleted");
            }
        }
        return result;
    }
}
//END
