package com.multithreading;

public class StartThreadExample implements Runnable{
    Thread t;

    StartThreadExample(){
        t = new Thread(this, "My thread");
        System.out.println("Child Thread: "+ t);
    }
    public void run(){
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("child Thread: "+i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting Child Thread");
    }
}
class ThreadDemo{
    public static void main(String[] args) {
        StartThreadExample nt = new StartThreadExample();
        nt.t.start();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Main Thread: "+i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting main thread.");

    }
}