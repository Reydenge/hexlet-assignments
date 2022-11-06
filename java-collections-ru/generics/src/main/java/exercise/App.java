package exercise;

import java.util.*;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> temp : books) {
            boolean found = true;
            for (Map.Entry<String, String> mItr : where.entrySet()) {
                String bookKey = mItr.getKey();
                String bookValue = mItr.getValue();
                String booksValue = temp.get(bookKey);
                if (!Objects.equals(booksValue, bookValue)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                result.add(temp);
            }
        }
        return result;
    }
}
//END
