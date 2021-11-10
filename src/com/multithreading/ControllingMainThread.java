package com.multithreading;

public class ControllingMainThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("Current thread "+t);

        t.setName("My thread");
        System.out.println("After name changed Current thread: "+t);

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
