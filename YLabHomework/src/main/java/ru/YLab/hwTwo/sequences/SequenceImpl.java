package ru.YLab.hwTwo.sequences;

public class SequenceImpl implements SequenceGenerator {

    /**
     * описание методов в интерфейсе
     */

    @Override
    public void a(int n) {
        System.out.print("A. ");
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    @Override
    public void b(int n) {
        System.out.print("B. ");
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }


    @Override
    public void c(int n) {
        System.out.print("C. ");
        for (int i = 1; i <= n; i++) {
            System.out.print((int) Math.pow(i, 2) + " ");
        }
        System.out.println();
    }

    @Override
    public void d(int n) {
        System.out.print("D. ");
        for (int i = 1; i <= n; i++) {
            System.out.print((int) Math.pow(i, 3) + " ");
        }
        System.out.println();
    }

    @Override
    public void e(int n) {
        System.out.print("E. ");
        for (int i = 0; i < n; i++) {
            System.out.print(i % 2 == 0 ? "1 " : "-1 ");
        }
        System.out.println();
    }

    @Override
    public void f(int n) {
        System.out.print("F. ");
        for (int i = 1; i <= n; i++) {
            System.out.print(i % 2 != 0 ? i + " " : "-" + i + " ");
        }
        System.out.println();
    }

    @Override
    public void g(int n) {
        System.out.print("G. ");
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print("-" + (int) Math.pow(i, 2) + " ");
            } else {
                System.out.print((int) Math.pow(i, 2) + " ");
            }
        }
        System.out.println();
    }

    @Override
    public void h(int n) {
        System.out.print("H. ");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " 0 ");
        }
        System.out.println();
    }

    @Override
    public void i(int n) {
        System.out.print("I. ");
        int mult = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(i * mult + " ");
            mult = i * mult;
        }
        System.out.println();
    }

    @Override
    public void j(int n) {
        System.out.print("J. ");
        int n0 = 1;
        int n1 = 1;
        int n2;
        System.out.print(n0 + " " + n1 + " ");
        for (int i = 0; i < n; i++) {
            n2 = n0 + n1;
            System.out.print(n2 + " ");
            n0 = n1;
            n1 = n2;
        }
        System.out.println();
    }
}
