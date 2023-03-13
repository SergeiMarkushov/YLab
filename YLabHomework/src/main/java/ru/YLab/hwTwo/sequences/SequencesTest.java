package ru.YLab.hwTwo.sequences;

public class SequencesTest {
    public static void main(String[] args) {
        SequenceImpl a = new SequenceImpl();

        a.a(10);
        a.b(10);
        a.c(10);
        a.d(10);
        a.e(10);
        a.f(10);
        a.g(10);
        a.h(10);
        a.i(10);
        a.j(10);

    }
}

/**
 * При N = 10
 * A. 2 4 6 8 10
 * B. 1 3 5 7 9
 * C. 1 4 9 16 25 36 49 64 81 100
 * D. 1 8 27 64 125 216 343 512 729 1000
 * E. 1 -1 1 -1 1 -1 1 -1 1 -1
 * F. 1 -2 3 -4 5 -6 7 -8 9 -10
 * G. 1 -4 9 -16 25 -36 49 -64 81 -100
 * H. 1 0 2 0 3 0 4 0 5 0 6 0 7 0 8 0 9 0 10 0
 * I. 1 2 6 24 120 720 5040 40320 362880 3628800
 * J. 1 1 2 3 5 8 13 21 34 55 89 144
 */
