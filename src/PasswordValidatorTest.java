import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test
    public void Test1(){
        ValidationResult result = PasswordValidator.validatePassword("StrongP@ss1!");
        assertEquals(true, result.isSuccess);
        assertEquals(0, result.errors.length);
    }

    @Test
    public void Test2(){
        ValidationResult result = PasswordValidator.validatePassword("Short1!");
        assertEquals(false, result.isSuccess);
        assertEquals(1, result.errors.length);
        assertEquals("Нужно не менее 8 символов", result.errors[0]);
    }

    @Test
    public void Test3(){
        ValidationResult result = PasswordValidator.validatePassword("VeryLongPassword123!@#");
        assertEquals(false, result.isSuccess);
        assertEquals(1, result.errors.length);
        assertEquals("Нужно не менее 16 символов", result.errors[0]);
    }

    @Test
    public void Test4(){
        ValidationResult result = PasswordValidator.validatePassword("lowercase123!@");
        assertEquals(false, result.isSuccess);
        assertEquals(1, result.errors.length);
        assertEquals("Нужна 1 заглавную буква", result.errors[0]);
    }

    @Test
    public void Test5(){
        ValidationResult result = PasswordValidator.validatePassword("UPPERCASE123!@");
        assertEquals(false, result.isSuccess);
        assertEquals(1, result.errors.length);
        assertEquals("Нужна 1 строчную буква", result.errors[0]);
    }

    @Test
    public void Test6(){
        ValidationResult result = PasswordValidator.validatePassword("Password123");
        assertEquals(false, result.isSuccess);
        assertEquals(1, result.errors.length);
        assertEquals("Нужно 2 специальных символа", result.errors[0]);
    }

    @Test
    public void Test7(){
        ValidationResult result = PasswordValidator.validatePassword("Password!@#");
        assertEquals(false, result.isSuccess);
        assertEquals(1, result.errors.length);
        assertEquals("Нужна 1 цифра", result.errors[0]);
    }

    @Test
    public void Test8(){
        ValidationResult result = PasswordValidator.validatePassword("MyP@$$w0rd!!");
        assertEquals(true, result.isSuccess);
        assertEquals(0, result.errors.length);
    }

    @Test
    public void Test9(){
        ValidationResult result = PasswordValidator.validatePassword(null);
        assertEquals(false, result.isSuccess);
        assertEquals(1, result.errors.length);
        assertEquals("Пароль не может быть null", result.errors[0]);
    }
}