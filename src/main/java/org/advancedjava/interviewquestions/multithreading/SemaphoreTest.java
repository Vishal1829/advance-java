package org.advancedjava.interviewquestions.multithreading;

import java.util.concurrent.Semaphore;

/*
4. Implement a Semaphore to Limit Concurrent Access
Problem: Write a program where only 3 threads can access a resource (e.g., print a message) at a time,
out of 6 threads trying to access it.
Why Asked: Tests understanding of advanced concurrency tools (Semaphore).

Explanation:
Semaphore with 3 permits limits concurrent access to 3 threads.
Others wait until a permit is released.

Sample output:
Thread-2 accessing resource
Thread-1 accessing resource
Thread-3 accessing resource
Thread-2 releasing resource
Thread-1 releasing resource
Thread-4 accessing resource
Thread-3 releasing resource
Thread-5 accessing resource
Thread-6 accessing resource
Thread-4 releasing resource
Thread-5 releasing resource
Thread-6 releasing resource
 */
class Resource {
    private final Semaphore semaphore = new Semaphore(3); // 2 permits

    public void access(String threadName) {
        try {
            semaphore.acquire();
            System.out.println(threadName + " accessing resource");
            Thread.sleep(200); // Simulate work
            System.out.println(threadName + " releasing resource");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

public class SemaphoreTest {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Runnable task = () -> resource.access(Thread.currentThread().getName());
        Thread[] threads = new Thread[6];
        for (int i = 0; i < 6; i++) {
            threads[i] = new Thread(task, "Thread-" + (i + 1));
            threads[i].start();
        }
    }
}
