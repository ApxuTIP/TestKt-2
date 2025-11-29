public class ValidationResult {
    public final boolean isSuccess;
    public final String[] errors;

    public ValidationResult(boolean isSuccess, String[] errors) {
        this.isSuccess = isSuccess;
        this.errors = errors;
    }
}