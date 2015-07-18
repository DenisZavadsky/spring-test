package com.levelup.sync;

import com.levelup.sync.blocking.Consumer1;
import com.levelup.sync.blocking.Producer1;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by denis_zavadsky on 7/18/15.
 */
public class MainTest {

    public static void main(String[] args) {
        MainTest test = new MainTest();
        test.test2();
    }

    private void test1(){
        Object lock = new Object();
        LinkedList<Message> list = new LinkedList<>();
        Consumer consumer = new Consumer(lock,list);
        Producer producer = new Producer(lock,list);

        Thread p = new Thread(producer);
        Thread c = new Thread(consumer);
        c.start();
        p.start();
    }

    private void test2(){
        ArrayBlockingQueue<Message> queue = new ArrayBlockingQueue<>(100);
        Consumer1 consumer1 = new Consumer1(queue);
        consumer1.setNumber(1);
        Consumer1 consumer2 = new Consumer1(queue);
        consumer2.setNumber(2);
        Producer1 producer = new Producer1(queue);

        Thread p = new Thread(producer);
        Thread c1 = new Thread(consumer1);
        Thread c2 = new Thread(consumer2);
        c1.start();
        c2.start();
        p.start();
    }
}
