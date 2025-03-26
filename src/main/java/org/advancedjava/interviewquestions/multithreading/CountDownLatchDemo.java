package org.advancedjava.interviewquestions.multithreading;

import java.util.concurrent.CountDownLatch;

/*
What is CountDownLatch?
Definition: A CountDownLatch is a synchronization mechanism that allows one or more threads to wait until a
set of operations (or events) being performed by other threads completes. It’s like a gate that opens once a
counter reaches zero.
Key Concept: It maintains a count initialized to a positive number. Threads can decrement this count (using countDown()),
and other threads can wait for the count to reach zero (using await()).
Purpose: Ensures that certain tasks are completed before proceeding with dependent tasks, without needing
complex manual synchronization.
How It Works:
Initialize the latch with a count (e.g., number of tasks or threads to wait for).
Worker threads call countDown() when they finish their task, reducing the count by 1.
Waiting threads call await() and block until the count hits zero, then proceed.

Key Methods:
CountDownLatch(int count): Constructor to set the initial count.
void countDown(): Decrements the count by 1. When it reaches zero, waiting threads are released.
void await(): Blocks the calling thread until the count reaches zero.
boolean await(long timeout, TimeUnit unit): Waits for the count to reach zero or until the timeout expires,
returning true if the count hit zero, false if timed out.
long getCount(): Returns the current count (useful for debugging).

Key Characteristics:
One-Time Use: Once the count reaches zero, the latch is “open” permanently and cannot be reused.
(Contrast with CyclicBarrier, which can reset.)
Thread-Safe: Multiple threads can safely call countDown() concurrently.
Blocking: await() blocks until the condition is met, unless a timeout is specified.

Interview Summary:
What It Is: A latch that counts down from an initial value to zero, unblocking waiting threads.
Key Methods: countDown() (decrement), await() (wait).
Use Case: Synchronize threads where one waits for others to finish (e.g., “wait for 5 downloads to complete”).
Example: Main thread waiting for worker threads, as shown above.
Contrast: Unlike Semaphore (controls access to resources), CountDownLatch is about waiting for events.

Example:
Imagine a scenario where a main thread needs 3 worker threads to finish their tasks before proceeding.
Insight: The main thread waits at await() until all 3 workers call countDown(), reducing the count from 3 to 0.
 */

class Worker implements Runnable {
    private final CountDownLatch latch;
    private final String name;

    Worker(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    public void run() {
        System.out.println(name + " is working...");
        try {
            Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " finished.");
        latch.countDown(); // Signal task completion
    }
}

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3); // Wait for 3 tasks

        // Start 3 worker threads
        Thread t1 = new Thread(new Worker(latch, "Worker 1"));
        Thread t2 = new Thread(new Worker(latch, "Worker 2"));
        Thread t3 = new Thread(new Worker(latch, "Worker 3"));

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Main thread waiting for workers...");
        latch.await(); // Main thread waits until count reaches 0

        System.out.println("All workers done. Main thread proceeding.");
    }
}