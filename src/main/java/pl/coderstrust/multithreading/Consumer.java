package pl.coderstrust.multithreading;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private int retrieveFrequencyInMillis;
    private String name;

    public Consumer(BlockingQueue<Integer> queue, int retrieveFrequencyInMillis, String name) {
        if (queue == null) {
            throw new IllegalArgumentException("Parameter queue cannot be null.");
        }
        if (retrieveFrequencyInMillis < 0) {
            throw new IllegalArgumentException("Parameter retrieveFrequencyInMillis cannot be lower than zero.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Parameter name cannot be null.");
        }
        this.queue = queue;
        this.retrieveFrequencyInMillis = retrieveFrequencyInMillis;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.printf("Consumer: %s take: %d, remaining queue: %d %n", name, queue.take(), queue.remainingCapacity());
                Thread.sleep(retrieveFrequencyInMillis);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
