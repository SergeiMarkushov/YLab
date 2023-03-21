package ru.YLab.hwThree.passwordValidator;

public class PasswordValidatorTest {
    public static void main(String[] args) {
        String l = "Test_1";
        String p1 = "Password_test_1";
        String p2 = "Password_test_1";

        System.out.println(PasswordValidator.validate(l, p1, p2));

    }
}
