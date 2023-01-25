package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;


class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    // BEGIN
    @Test
    void testAdvancedValidate() throws IllegalAccessException {
        Address address = new Address("Jap", "Tokyo", "Akihabara", null, null);
        Map<String, List<String>> firstValidate = Validator.advancedValidate(address);
        Map<String, List<String>> validatedAddress = Map.of("country", List.of("length less then 4"),
                "houseNumber", List.of("can not be null"));
        assertThat(validatedAddress).isEqualTo(firstValidate);
    }
    // END
}
