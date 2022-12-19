package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage dataStorage) {
        Set<String> keySet = dataStorage.toMap().keySet();
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> mapEntry : dataStorage.toMap().entrySet()) {
            tempMap.put(mapEntry.getValue(), mapEntry.getKey());
        }
        for (String key : keySet) {
            dataStorage.unset(key);
        }
        for (Map.Entry<String, String> mapEntry : tempMap.entrySet()) {
            dataStorage.set(mapEntry.getKey(), mapEntry.getValue());
        }
    }
}
// END
