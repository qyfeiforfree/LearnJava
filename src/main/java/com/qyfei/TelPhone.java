package com.qyfei;

public class TelPhone {
    float mem = 2.0f;
    float screen = 5.5f;
    float cpu = 1.4f;

    public void call() {
        System.out.println("Telphone cam call");
    }

    public void sendmsg() {
        System.out.println("Mem is :" + mem + "  Screen is :" + screen + "  Cpu is :" + cpu);
    }

    public static void main(String[] args) {

        TelPhone tp = new TelPhone();
        tp.sendmsg();
    }
}
