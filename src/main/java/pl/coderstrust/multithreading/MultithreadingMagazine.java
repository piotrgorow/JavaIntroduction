package pl.coderstrust.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadingMagazine {

    public static void main(String[] args) {
        MultithreadingMagazine multithreadingMagazine = new MultithreadingMagazine();
        multithreadingMagazine.fiveProducersAndOneConsumer();
    }

    public void oneProducerAndOneConsumer() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        AtomicInteger counter = new AtomicInteger();
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(new Producer(queue, 500, "Producer-1", counter));
        threadPool.submit(new Consumer(queue, 500, "Consumer-1"));
    }

    public void fiveProducersAndOneConsumer() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        AtomicInteger counter = new AtomicInteger();
        ExecutorService threadPool = Executors.newFixedThreadPool(6);
        threadPool.submit(new Producer(queue, 500, "Producer-1", counter));
        threadPool.submit(new Producer(queue, 500, "Producer-2", counter));
        threadPool.submit(new Producer(queue, 500, "Producer-3", counter));
        threadPool.submit(new Producer(queue, 500, "Producer-4", counter));
        threadPool.submit(new Producer(queue, 500, "Producer-5", counter));
        threadPool.submit(new Consumer(queue, 500, "Consumer-1"));
    }

    public void oneProducerAndFiveConsumers() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        AtomicInteger counter = new AtomicInteger();
        ExecutorService threadPool = Executors.newFixedThreadPool(6);
        threadPool.submit(new Producer(queue, 500, "Producer-1", counter));
        threadPool.submit(new Consumer(queue, 500, "Consumer-1"));
        threadPool.submit(new Consumer(queue, 500, "Consumer-2"));
        threadPool.submit(new Consumer(queue, 500, "Consumer-3"));
        threadPool.submit(new Consumer(queue, 500, "Consumer-4"));
        threadPool.submit(new Consumer(queue, 500, "Consumer-5"));
    }
}
