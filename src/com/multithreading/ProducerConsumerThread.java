package com.multithreading;

class   MyQueue{
    int num;
    boolean valueSet  = false;

    synchronized int get()
    {
        while (!valueSet)
        {
            try {
                wait();
            }
            catch (InterruptedException exception)
            {
                System.out.println("Interrupted exception caught");
            }
        }
        System.out.println("Got :" +num);
        valueSet =  false;
        notify();
        return num;
    }

    synchronized  void put(int num){
        while (valueSet)
        {
            try {
                wait();
            }
            catch (InterruptedException exception)
            {
                System.out.println("Interrupted exception caught");
            }
        }
        this.num = num;
        valueSet =  true;
        System.out.println("Put :" +num);
        notify();
    }
}

class Producer implements  Runnable {
    MyQueue myQueue;
    Thread thread;
    Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
        thread = new Thread(this,"Producer");
    }

    @Override
    public void run() {
        int num  =  0;
        while (num <5)
        {
            myQueue.put(num++);
        }
    }
}

class Consumer implements  Runnable {
    MyQueue myQueue;
    Thread thread;
    Consumer(MyQueue myQueue) {
        this.myQueue = myQueue;
        thread = new Thread(this,"Consumer");
    }

    @Override
    public void run() {
        int num  =  0;
        while (num <5)
        {
            myQueue.get();
            num ++;
        }
    }
}

public class ProducerConsumerThread {
    public static void main(String[] args) {
        MyQueue myQueueObj = new MyQueue();
        Producer producerObj = new Producer(myQueueObj);
        Consumer consumerObj = new Consumer(myQueueObj);
        // start the threads
        producerObj.thread.start();
        consumerObj.thread.start();

        System.out.println(" Main Thread is exiting ");
    }
}
