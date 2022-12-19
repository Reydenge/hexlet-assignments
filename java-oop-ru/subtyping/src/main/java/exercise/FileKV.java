package exercise;

import java.util.HashMap;
import java.util.Map;
// BEGIN
public class FileKV implements KeyValueStorage {
    private Map<String, String> dataStorage = new HashMap<>();
    private final String path;
    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        this.dataStorage.putAll(map);
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
    public void saveFileVK() {
        String content = Utils.serialize(this.dataStorage);
        Utils.writeFile(this.path, content);
    }
    public void getFileContent() {
        String content = Utils.readFile(this.path);
        this.dataStorage = Utils.unserialize(content);
    }
}
// END
