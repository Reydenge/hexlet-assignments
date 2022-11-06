package exercise;

import java.util.*;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>(books);
        for (Map<String, String> temp : books) {
            for (Map.Entry<String, String> mItr : where.entrySet()) {
                String bookKey = mItr.getKey();
                String bookValue = mItr.getValue();
                String booksValue = temp.get(bookKey);
                if (!Objects.equals(booksValue, bookValue)) {
                    result.remove(temp);
                }
            }
            }
        return result;
    }
}
//END
