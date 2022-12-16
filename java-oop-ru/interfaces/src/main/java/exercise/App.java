package exercise;

import java.util.List;

// BEGIN
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static List<String> buildAppartmentsList(List<Home> appartments, int num) {
        List<String> result = new ArrayList<>();
        if (appartments.size() == 0) {
            return result;
        }
        appartments.sort(COMPARE_BY_AREA);
        for (int i = 0; i < num; i++) {
            result.add(appartments.get(i).toString());
        }
        return result;
    }
    public static Comparator<Home> COMPARE_BY_AREA = new Comparator<Home>() {
        @Override
        public int compare(Home o1, Home o2) {
            return (int) (o1.getArea() - o2.getArea());
        }
    };
}
// END
