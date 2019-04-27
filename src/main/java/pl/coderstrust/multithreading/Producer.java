package pl.coderstrust.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private BlockingQueue<Integer> queue;
    private int insertFrequencyInMillis;
    private String name;
    private AtomicInteger counter;

    public Producer(BlockingQueue<Integer> queue, int insertFrequencyInMillis, String name, AtomicInteger counter) {
        this.queue = queue;
        this.insertFrequencyInMillis = insertFrequencyInMillis;
        this.name = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(insertFrequencyInMillis);
                int count = counter.incrementAndGet();
                queue.put(count);
                System.out.printf("Producer: %s put: %d remaining queue: %d  %n", name, count,  queue.remainingCapacity());
            } catch (InterruptedException e) {
                System.out.println("Queue is full - producer " + name + " is waiting...");
            }
        }
    }
}
