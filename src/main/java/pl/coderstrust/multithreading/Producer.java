package pl.coderstrust.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private BlockingQueue<Integer> queue;
    private int insertFrequencyInMillis;
    private String name;
    private AtomicInteger counter;

    public Producer(BlockingQueue<Integer> queue, int insertFrequencyInMillis, String name, AtomicInteger counter) {
        if (queue == null) {
            throw new IllegalArgumentException("Parameter queue cannot be null.");
        }
        if (insertFrequencyInMillis < 0) {
            throw new IllegalArgumentException("Parameter insertFrequencyInMillis cannot be lower than zero.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Parameter name cannot be null.");
        }
        if (counter == null) {
            throw new IllegalArgumentException("Parameter counter cannot be null.");
        }
        this.queue = queue;
        this.insertFrequencyInMillis = insertFrequencyInMillis;
        this.name = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int count = counter.incrementAndGet();
                queue.put(count);
                System.out.printf("Producer: %s put: %d remaining queue: %d  %n", name, count, queue.remainingCapacity());
                Thread.sleep(insertFrequencyInMillis);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
