package ru.YLab.hwTwo.complexNumbers;

public class ComplexNumber {
    private final double real;
    private double imaginary;

    public ComplexNumber(double real) {
        this.real = real;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber addition(ComplexNumber addNumber) {
        double real2 = addNumber.getReal();
        double imaginary2 = addNumber.getImaginary();
        double newReal = real + real2;
        double newImaginary = imaginary + imaginary2;
        return new ComplexNumber(newReal, newImaginary);
    }


    public ComplexNumber subtraction(ComplexNumber subNumber) {
        double real2 = subNumber.getReal();
        double imaginary2 = subNumber.getImaginary();
        double newReal = real - real2;
        double newImaginary = imaginary - imaginary2;
        return new ComplexNumber(newReal, newImaginary);
    }


    public ComplexNumber multiplication(ComplexNumber multNumber) {
        double real2 = multNumber.getReal();
        double imaginary2 = multNumber.getImaginary();
        double newReal = real * real2 - imaginary * imaginary2;
        double newImaginary = imaginary * real2 + real * imaginary2;
        return new ComplexNumber(newReal, newImaginary);
    }

    public double getModule() {
        return Math.sqrt(Math.pow(this.getImaginary(), 2) + Math.pow(this.getReal(), 2));
    }

    @Override
    public String toString() {
        return "ComplexNumber:" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '.';
    }
}