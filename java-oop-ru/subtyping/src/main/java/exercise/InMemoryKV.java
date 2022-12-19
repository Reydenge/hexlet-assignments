package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> dataStorage = new HashMap<>();

    public InMemoryKV(Map<String, String> requiredMap) {
        this.dataStorage.putAll(requiredMap);
    }
    @Override
    public void set(String key, String value) {
        this.dataStorage.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.dataStorage.remove(key);
    }
    @Override
    public String get(String key, String defaultValue) {
        return this.dataStorage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(this.dataStorage);
    }
}
// END
