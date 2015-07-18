package com.levelup.sync;

import java.util.LinkedList;

/**
 * Created by denis_zavadsky on 7/18/15.
 */
public class Producer implements Runnable {

    private final Object lock;
    private final LinkedList<Message> linkedList;



    public Producer(Object lock, LinkedList<Message> linkedList) {
        this.lock = lock;
        this.linkedList = linkedList;
    }

    @Override
    public void run() {
        int i=0;
        while (true){

                Message message = new Message("Test Message " + i);
                i++;
                linkedList.push(message);
                synchronized (lock) {
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }
}
