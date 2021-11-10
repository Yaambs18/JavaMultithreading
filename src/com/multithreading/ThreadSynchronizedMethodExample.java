package com.multithreading;

class Callme2{
    synchronized  void call(String msg){
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
class Caller2 implements Runnable{
    String msg;
    Callme2 target;
    Thread thread;

    public Caller2(Callme2 targ, String str)
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
public class ThreadSynchronizedMethodExample {
    public static void main(String[] args) {
        Callme2 target = new Callme2();
        Caller2 obj1 = new Caller2(target, "Hello");
        Caller2 obj2 = new Caller2(target, "Synchronized");
        Caller2 obj3 = new Caller2(target, "World");

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

