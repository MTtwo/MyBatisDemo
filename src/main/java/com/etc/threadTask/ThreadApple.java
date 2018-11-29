package com.etc.threadTask;

public class ThreadApple extends Thread {
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("线程：吃苹果第"+i+"个");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
