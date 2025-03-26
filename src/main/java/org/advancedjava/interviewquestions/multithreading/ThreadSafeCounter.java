package org.advancedjava.interviewquestions.multithreading;

/*
2. Implement a Thread-Safe Counter
Problem: Create a counter class that multiple threads can increment safely, starting from 0 up to 1000.
Why Asked: Tests synchronization techniques.

Explanation: synchronized ensures atomic increments, avoiding race conditions. Alternative: Use AtomicInteger.
 */
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class ThreadSafeCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 500; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final Count: " + counter.getCount()); // Should be 1000
    }
}
