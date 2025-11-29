import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {

    public static ValidationResult validatePassword(String password) {
        List<String> errors = new ArrayList<>();

        if (password == null) {
            errors.add("Пароль не может быть null");
            return new ValidationResult(false, errors.toArray(new String[0]));
        }

        // Проверяем все условия и собираем ошибки
        if (!checkMinLength(password)) {
            errors.add("Пароль должен быть не менее 8 символов");
        }
        if (!checkMaxLength(password)) {
            errors.add("Пароль должен быть не более 16 символов");
        }
        if (!checkUpperCase(password)) {
            errors.add("Пароль должен содержать хотя бы 1 заглавную букву");
        }
        if (!checkLowerCase(password)) {
            errors.add("Пароль должен содержать хотя бы 1 строчную букву");
        }
        if (!checkSpecialChars(password)) {
            errors.add("Пароль должен содержать хотя бы 2 специальных символа");
        }
        if (!checkDigits(password)) {
            errors.add("Пароль должен содержать хотя бы 1 цифру");
        }

        return new ValidationResult(errors.isEmpty(), errors.toArray(new String[0]));
    }

    private static boolean checkMinLength(String password) {
        return password.length() >= 8;
    }

    private static boolean checkMaxLength(String password) {
        return password.length() <= 16;
    }

    private static boolean checkUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSpecialChars(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (isSpecialChar(c)) {
                count++;
                if (count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSpecialChar(char c) {
        String specialChars = "!@#$%^&*()_+-=[]{};':\"|,.<>/?\\";
        return specialChars.indexOf(c) != -1;
    }
}