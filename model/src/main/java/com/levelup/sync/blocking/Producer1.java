package com.levelup.sync.blocking;

import com.levelup.sync.Message;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by denis_zavadsky on 7/18/15.
 */
public class Producer1 implements Runnable {
    private final ArrayBlockingQueue<Message> queue;

    public Producer1(ArrayBlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i =0;
        while (true) {

            Message message = new Message("Test Message " + i);
            i++;
            try {
                queue.put(message);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
