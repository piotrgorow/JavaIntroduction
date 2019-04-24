package pl.coderstrust.multithreading;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MultithreadingMagazine {
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    private Runnable producer = () -> {
        int i = 0;
        while (true) {
            try {
                queue.add(i++);
                System.out.println("Producer put: " + i + " remaining queue " + queue.remainingCapacity());
            } catch (IllegalStateException e) {
                System.out.println("Queue is full - producer is waiting...");
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    };
    private Runnable consumer = () -> {
        while (true) {
            try {
                System.out.println("Consumer take: " + queue.remove() + " remaining queue " + queue.remainingCapacity());
            } catch (NoSuchElementException e) {
                System.out.println("Queue is empty - consumer is waiting...");
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    };

    public static void main(String[] args) {
        MultithreadingMagazine multithreadingMagazine = new MultithreadingMagazine();
        new Thread(multithreadingMagazine.producer).start();
        new Thread(multithreadingMagazine.producer).start();
    }
}
