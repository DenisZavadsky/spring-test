package com.levelup.sync;

import java.util.LinkedList;

/**
 * Created by denis_zavadsky on 7/18/15.
 */
public class Consumer implements Runnable {

    private final Object lock;
    private final LinkedList<Message> linkedList;

    public Consumer(Object lock, LinkedList<Message> linkedList) {
        this.lock = lock;
        this.linkedList = linkedList;
    }

    @Override
    public void run() {
        while (true){

                if (linkedList.size() > 0) {
                    Message message = linkedList.pop();
                    System.out.println(message.getContent());
                }
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
