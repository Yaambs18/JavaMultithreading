package com.multithreading;

class Callme{
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
class Caller implements Runnable{
    String msg;
    Callme target;
    Thread thread;

    public Caller(Callme targ, String str)
    {
        target = targ;
        msg = str;
        thread = new Thread(this);
    }

    public void run()
    {
        target.call(msg);
    }
}
public class Sync {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller obj1 = new Caller(target, "Hello");
        Caller obj2 = new Caller(target, "Synchronized");
        Caller obj3 = new Caller(target, "World");

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
