package com.multithreading;

public class MyThread
{
    public static void main(String[] args)
    {
        Thread thread= new Thread("My first thread");

        thread.start();
        String name = thread.getName();
        System.out.println(name);
    }
}
