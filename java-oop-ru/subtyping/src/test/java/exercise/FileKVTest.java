package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void fileKVTest() {
        FileKV fileKV = new FileKV(filepath.toString(), new HashMap<>(Map.of("key1", "value1")));

        String testingValue = fileKV.get("key1", "default");
        assertThat(testingValue).isEqualTo("value1");

        fileKV.set("key2", "value2");
        Map<String, String> firstTestingMap = new HashMap<>(Map.of("key1", "value1", "key2", "value2"));
        assertThat(fileKV.toMap()).isEqualTo(firstTestingMap);

        fileKV.unset("key2");
        Map<String, String> secondTestingMap = new HashMap<>(Map.of("key1", "value1"));
        assertThat(fileKV.toMap()).isEqualTo(secondTestingMap);

        fileKV.saveFileVK();
        String actualString = Utils.readFile(filepath.toString());
        String expectedString = "{\"key1\":\"value1\"}";
        assertThat(actualString).isEqualTo(expectedString);

        fileKV.getFileContent();
        Map<String, String> thirdTestingMap = new HashMap<>(Map.of("key1", "value1"));
        assertThat(fileKV.toMap()).isEqualTo(thirdTestingMap);
        }
    // END
}
