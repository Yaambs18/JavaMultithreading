package com.multithreading;

class NewThread3 implements Runnable{
    String name;
    Thread thread;
    boolean suspendFlag;

    NewThread3(String threadName){
        name = threadName;
        thread = new Thread(this, name);
        System.out.println("New Thread: "+thread);
        suspendFlag =false;
    }

    @Override
    public void run() {
        try{
            for(int count=15;count>0;count--){
                System.out.println(name + ": "+ count);
                Thread.sleep(200);
                synchronized (this){
                    while(suspendFlag){
                        wait();
                    }
                }
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(name + " Interrupted");
        }
        System.out.println(name + " exiting");
    }

    synchronized void mysuspend(){
        suspendFlag = true;
    }

    synchronized void myresume(){
        suspendFlag = false;
        notify();
    }
}
public class SuspendResumeThread {
    public static void main(String[] args) {
        NewThread3 obj1 = new NewThread3("One");
        NewThread3 obj2 = new NewThread3("Two");

        obj1.thread.start();
        obj2.thread.start();

        try{
            Thread.sleep(1000);
            obj1.mysuspend();
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            obj1.myresume();
            System.out.println("Resuming thread One");

            Thread.sleep(1000);
            obj2.mysuspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            obj2.myresume();
            System.out.println("Resuming thread Two");
        }
        catch (InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }
        try{
            System.out.println("Waiting for threads to finish");
            obj1.thread.join();
            obj2.thread.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}
