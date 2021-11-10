package com.multithreading;

public class MyThread
{
    public static void main(String[] args)
    {
        Thread t= new Thread("My first thread");

        t.start();
        String name = t.getName();
        System.out.println(name);
    }
}
