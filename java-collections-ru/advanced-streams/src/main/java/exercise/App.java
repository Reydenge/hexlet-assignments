package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String config) {
        String[] environmentVariables = config.split("\n");
        return Arrays.stream(environmentVariables)
                .filter(var -> var.startsWith("environment="))
                .map(var -> var.replaceAll("environment=", ""))
                .map(var -> var.replaceAll("\"",""))
                .map(var -> var.split(","))
                .flatMap(Arrays::stream)
                .filter(var -> var.startsWith("X_FORWARDED_"))
                .map(var -> var.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
