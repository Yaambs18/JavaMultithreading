package com.multithreading;

public class FactoryMethod extends Thread{
    public static FactoryMethod createAndStart(){
        FactoryMethod threadObj = new FactoryMethod();
        threadObj.start();
        return threadObj;
    }

    @Override
    public void run() {
        System.out.println("Thread is started and running");
    }

    public static void main(String[] args) {
        FactoryMethod.createAndStart();    // create and start thread at the same time

        Thread obj = new Thread();    // creating thread
        obj.start();                   // starting the thread
    }
}
