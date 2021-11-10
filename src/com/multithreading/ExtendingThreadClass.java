package com.multithreading;

class NewThread extends Thread{
    NewThread(){
        super("DemoThread");
        System.out.println("Child thread: "+this);
    }
    public void run(){
        try{
            for(int i=0;i<5;i++){
                System.out.println("Child Thread: "+i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Child Thread Exiting");
    }
}
public class ExtendingThreadClass {
    public static void main(String[] args) {
        NewThread nt = new NewThread();

        nt.start();

        try {
            for (int i=0; i < 5; i++) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread Exiting");
    }

}
