package pl.coderstrust.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadingMagazine {

    public void oneProducerAndOneConsumer() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        AtomicInteger counter = new AtomicInteger();
        new Thread(new Producer(queue, 500, "Producer-1", counter)).start();
        new Thread(new Consumer(queue, 500, "Consumer-1")).start();
    }

    public void fiveProducersAndOneConsumer() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        AtomicInteger counter = new AtomicInteger(0);
        new Thread(new Producer(queue, 500, "Producer-1", counter)).start();
        new Thread(new Producer(queue, 500, "Producer-2", counter)).start();
        new Thread(new Producer(queue, 500, "Producer-3", counter)).start();
        new Thread(new Producer(queue, 500, "Producer-4", counter)).start();
        new Thread(new Producer(queue, 500, "Producer-5", counter)).start();
        new Thread(new Consumer(queue, 500, "Consumer-1")).start();
    }

    public void oneProducerAndFiveConsumers() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        AtomicInteger counter = new AtomicInteger();
        new Thread(new Producer(queue, 500, "Producer-1", counter)).start();
        new Thread(new Consumer(queue, 500, "Consumer-1")).start();
        new Thread(new Consumer(queue, 500, "Consumer-2")).start();
        new Thread(new Consumer(queue, 500, "Consumer-3")).start();
        new Thread(new Consumer(queue, 500, "Consumer-4")).start();
        new Thread(new Consumer(queue, 500, "Consumer-5")).start();
    }
}
