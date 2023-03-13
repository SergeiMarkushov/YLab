package ru.YLab.hwTwo.complexNumbers;

public class ComplexNumberTest {
    public static void main(String[] args) {

        ComplexNumber c1 = new ComplexNumber(5);
        ComplexNumber c2 = new ComplexNumber(5, 5);

        // сумма
        System.out.println(c1.addition(c2).toString());

        // вычитание
        System.out.println(c1.subtraction(c2).toString());

        // умножение
        System.out.println(c1.multiplication(c2).toString());


        // получение модуля
        ComplexNumber one = new ComplexNumber(10, 5);
        System.out.println("Module of " + one + " = " + one.getModule());
    }
}

/**
 * Сомневаюсь на счет правильности умножения
 * <p>
 * ComplexNumber{real=10.0, imaginary=5.0} - сумма 5 и 5(5)
 * ComplexNumber{real=0.0, imaginary=-5.0} - разница 5 и 5(5)
 * ComplexNumber{real=25.0, imaginary=25.0} - умножение 5 и 5(5)
 * 11.180339887498949 - модуль числа 10(5)
 */
