package com.multithreading;

public class ThreadsIsAliveAndJoin {
    public static void main(String[] args) {
        NewThread2 thread1 = new NewThread2("One");
        NewThread2 thread2 = new NewThread2("Two");
        NewThread2 thread3 = new NewThread2("Three");

        thread1.thread.start();
        thread2.thread.start();
        thread3.thread.start();

        System.out.println("thread one is alive "+thread1.thread.isAlive());
        System.out.println("thread two is alive "+thread2.thread.isAlive());
        System.out.println("thread three is alive "+thread3.thread.isAlive());

        try
        {
            System.out.println("waiting for the threads to finish.");
            thread1.thread.join();
            thread2.thread.join();
            thread3.thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("thread one is alive "+thread1.thread.isAlive());
        System.out.println("thread two is alive "+thread2.thread.isAlive());
        System.out.println("thread three is alive "+thread3.thread.isAlive());

        System.out.println("Main thread exiting.");
    }
}
