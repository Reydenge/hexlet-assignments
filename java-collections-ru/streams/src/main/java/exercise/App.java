package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> data) {
        return data.stream().map(email -> email.substring(email.indexOf("@")))
                .filter(subStr -> subStr.equals("@gmail.com")|| subStr.equals("@yandex.ru")||
                        subStr.equals("@hotmail.com")).count();
    }
}
// END
