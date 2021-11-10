package com.multithreading;

class Foo{
    synchronized void foo(Bar barObj){
        String name = Thread.currentThread().getName();

        System.out.println(name + "entered Foo.foo");

        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Foo interrupted");
        }
        System.out.println(name + " trying to call Bar.last()");
        barObj.last();
    }
    synchronized void last(){
        System.out.println("Inside Foo.last");
    }
}
class Bar{
    synchronized void bar(Foo fooObj){
        String name = Thread.currentThread().getName();

        System.out.println(name + "entered Bar.bar");

        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Bar interrupted");
        }
        System.out.println(name + " trying to call Foo.last()");
        fooObj.last();
    }
    synchronized void last(){
        System.out.println("Inside Bar.last");
    }
}
public class DeadlockExample implements Runnable{
    Foo fooObj = new Foo();
    Bar barObj = new Bar();
    Thread thread;

    DeadlockExample(){
        Thread.currentThread().setName("MainThread");
        thread = new Thread(this, "RacingThread");
    }

    void deadLockStart(){
        thread.start();
        fooObj.foo(barObj);  // get deadlock on fooObj in this thread
        System.out.println("Back in main thread");
    }

    @Override
    public void run() {
        barObj.bar(fooObj);   // get deadlock on barObj in this thread
        System.out.println("Back in other thread");
    }

    public static void main(String[] args) {
        DeadlockExample obj = new DeadlockExample();
        obj.deadLockStart();
    }
}
