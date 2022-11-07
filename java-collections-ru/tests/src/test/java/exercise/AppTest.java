package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> testArray = List.of(3, 1, 17, 1, 16, 2, 29, 10);
        List<Integer> emptyArray = new ArrayList<>();

        int lengthOne = App.take(testArray, 10).size();
        assertThat(lengthOne).isEqualTo(testArray.size());

        List<Integer> testArray1 = App.take(testArray, 0);
        assertThat(testArray1).isEmpty();

        List<Integer> testArray2 = App.take(emptyArray, 5);
        assertThat(testArray2).isEmpty();

        int lengthTwo = App.take(testArray, 2).size();
        assertThat(lengthTwo).isEqualTo(2);

        List<Integer> testArray3 = App.take(testArray, -5);
        assertThat(testArray3).isEmpty();
        // END
    }
}
