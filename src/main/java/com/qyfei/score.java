package com.qyfei;

import java.util.Scanner;


public class score {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入上次成绩:");
        float before = scanner.nextFloat();
        System.out.println("输入这次成绩:");
        float now = scanner.nextFloat();
        float res = now - before;
        float arve = res / before * 100;
        if (res > 0) {
            System.out.printf("比上次成绩提升了%.2f %%！", arve);
        } else if (res == 0) {
            System.out.printf("本次未提升100!");
        } else {
            arve = -arve;
            System.out.printf("比上次成绩降低了%.2f %%！", arve);
        }

        Adder adder = new Adder();
        adder.add(3)
                .add(5)
                .inc()
                .add(10);
        System.out.println(adder.value());
    }
}

class Adder {
    private int sum = 0;

    public Adder add(int n) {
        sum += n;
        return this;
    }

    public Adder inc() {
        sum++;
        return this;
    }

    public int value() {
        return sum;
    }
}
class Computer<T>{
    private T first;
    private T last;
    public Computer(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
}

