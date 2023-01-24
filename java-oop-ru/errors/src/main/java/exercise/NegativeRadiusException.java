package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private String massage;

    public NegativeRadiusException(String massage) {
        this.massage = massage;
    }

    @Override
    public String getMessage() {
        return massage;
    }
}
// END
