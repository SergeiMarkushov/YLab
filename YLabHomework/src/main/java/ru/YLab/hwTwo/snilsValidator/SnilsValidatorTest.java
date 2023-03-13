package ru.YLab.hwTwo.snilsValidator;

public class SnilsValidatorTest {
    public static void main(String[] args) {
        System.out.println(new SnilsValidatorImpl().validate("")); //false
        System.out.println(new SnilsValidatorImpl().validate(" ")); //false
        System.out.println(new SnilsValidatorImpl().validate("           ")); //false
        System.out.println(new SnilsValidatorImpl().validate(null)); //false
        System.out.println(new SnilsValidatorImpl().validate("0146887057")); //false
        System.out.println(new SnilsValidatorImpl().validate("014688705t2")); //false
        System.out.println(new SnilsValidatorImpl().validate("01468870570")); //false
        System.out.println(new SnilsValidatorImpl().validate("90114404441")); //true
    }
}
