package exercise;

import java.util.Map;
// BEGIN
public class Tag {
    protected final String tag;
    protected final Map<String, String> attributes;

    public Tag(String tag, Map<String, String> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }
    public String toString() {
        StringBuilder result = new StringBuilder("<");
        result.append(tag);
        for (var entry : attributes.entrySet()) {
            result.append(" ").append(entry.getKey()).append("=").append("\"").append(entry.getValue()).append("\"");
        }
        result.append(">");
        return result.toString();
    }
}
// END
