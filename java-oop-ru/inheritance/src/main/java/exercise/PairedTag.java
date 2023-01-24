package exercise;

import java.util.Map;
import java.util.List;
// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> children;

    public PairedTag (String tag, Map<String, String> attributes, String tagBody, List<Tag> children) {
        super(tag, attributes);
        this.tagBody = tagBody;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        for (var child : children) {
            result.append(child.toString());
        }
        result.append(tagBody).append("</").append(tag).append(">");
        return result.toString();
    }
}
// END
