package com.multithreading;

class Callme3{
    void call(String msg){
        System.out.print(" [ "+msg);
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted");
        }
        System.out.println(" ] ");
    }
}
class Caller3 implements Runnable{
    String msg;
    Callme3 target;
    Thread thread;

    public Caller3(Callme3 targ, String str)
    {
        target = targ;
        msg = str;
        thread = new Thread(this);
    }

    public void run(){
        synchronized (target){
            target.call(msg);
        }
    }
}
public class ThreadSynchronizedStatement {
    public static void main(String[] args) {
        Callme3 target = new Callme3();
        Caller3 obj1 = new Caller3(target, "Hello");
        Caller3 obj2 = new Caller3(target, "Synchronized");
        Caller3 obj3 = new Caller3(target, "World");

        obj1.thread.start();
        obj2.thread.start();
        obj3.thread.start();

        try {
            obj1.thread.join();
            obj2.thread.join();
            obj3.thread.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Interrupted");
        }
    }
}
