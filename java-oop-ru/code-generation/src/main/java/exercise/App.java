package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path pathToSaveFile, Car car) {
        String data  = car.serialize();
        try {
            Files.write(pathToSaveFile, data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Car extract(Path filepath) {
        String data;
        try {
            data = Files.readString(filepath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Car.unserialize(data);
    }
}
// END
