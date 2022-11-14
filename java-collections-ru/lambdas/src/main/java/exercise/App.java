package exercise;

import java.util.Arrays;

// BEGIN
class App {
    public static String[] doubleValues(String[] values) {
        return Arrays.stream(values)
                .flatMap(value -> Arrays.stream(new String[]{value, value}))
                .toArray(String[]::new);
    }

    public static String[][] enlargeArrayImage(String[][] image) {
        String[][] horizontallyEnlarged = Arrays.stream(image)
                .map(App::doubleValues).toArray(String[][]::new);
        return Arrays.stream(horizontallyEnlarged)
                .flatMap(value -> Arrays.stream(new String[][]{value, value}))
                .toArray(String[][]::new);
    }
}
// END
