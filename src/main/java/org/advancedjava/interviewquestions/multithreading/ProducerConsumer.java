package org.advancedjava.interviewquestions.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
3. Producer-Consumer Problem Using BlockingQueue
Problem: Implement a producer-consumer pattern where one thread produces numbers (1 to 5) and another consumes them.
Why Asked: Tests thread coordination with modern utilities.

Note: Output: (Order may vary slightly due to timing)

Explanation: BlockingQueue handles synchronization and blocking automatically (e.g., put() waits if full, take() waits if empty).
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    queue.put(i); // Blocks if queue is full (size 2)
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    int value = queue.take(); // Blocks if queue is empty
                    System.out.println("Consumed: " + value);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();
    }
}
/*
What Does the Size (Capacity) Mean?
In new LinkedBlockingQueue<>(2), the 2 is the capacity of the queue—the maximum number of elements
it can hold before it blocks the producer.
A BlockingQueue is a thread-safe queue that supports blocking operations:
put(): Adds an element; if the queue is full (at capacity), it blocks the producer until space is available.
take(): Removes an element; if the queue is empty, it blocks the consumer until an element is added.
By setting the capacity to 2, the queue can store up to 2 elements at any time.
 */