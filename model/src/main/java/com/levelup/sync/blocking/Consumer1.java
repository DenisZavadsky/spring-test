package com.levelup.sync.blocking;

import com.levelup.sync.Message;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by denis_zavadsky on 7/18/15.
 */
public class Consumer1 implements Runnable {

    private int number;

    private final ArrayBlockingQueue<Message> queue;

    public Consumer1(ArrayBlockingQueue<Message> queue) {
        this.queue = queue;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message message = queue.take();
                System.out.println("Consumer "+number+" : "+message.getContent());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
