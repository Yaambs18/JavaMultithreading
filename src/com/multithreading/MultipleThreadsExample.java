package com.multithreading;

class NewThread2 implements Runnable {
    String name;
    Thread thread;

    NewThread2(String threadname) {
        name = threadname;
        thread = new Thread(this, name);
        System.out.println("New Thread: " + thread);
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting "+name+" Thread");
    }
}
public class MultipleThreadsExample {
    public static void main(String[] args) {
        NewThread2 thread1 = new NewThread2("One");
        NewThread2 thread2 = new NewThread2("Two");
        NewThread2 thread3 = new NewThread2("Three");

        thread1.thread.start();
        thread2.thread.start();
        thread3.thread.start();

        try {
            for (int i=0; i < 5; i++) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread Exiting");
    }
}
