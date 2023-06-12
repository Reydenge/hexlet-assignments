package exercise;

import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;

import static java.nio.file.Files.write;
import static java.nio.file.Files.readString;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String firstFile, String secondFile, String unionFile) {
        CompletableFuture<String> content1 = getText(firstFile);
        CompletableFuture<String> content2 = getText(secondFile);

        return content1.thenCombine(content2, (fileFuture1, fileFuture2) -> {
            Path path = Paths.get(unionFile);

            try {
                write(path, (fileFuture1 + fileFuture2).getBytes(), StandardOpenOption.CREATE);
            } catch (IOException error) {
                System.out.println("NoSuchFileException");
            }
            return "Success";
        });
    }

    private static CompletableFuture<String> getText(String file) {

        return CompletableFuture.supplyAsync(() -> {
            Path path = Paths.get(file);
            String content = "";

            try {
                content = readString(path);
            } catch (IOException error) {
                System.out.println("NoSuchFileException");
            }
            return content;
        });
    }
    // END
    public static void main(String[] args) throws Exception {
        // BEGIN
        System.out.println(unionFiles("src/main/resources/file1.txt",
                        "src/main/resources/file2.txt",
                        "result.txt").get());
        // END
    }
}
