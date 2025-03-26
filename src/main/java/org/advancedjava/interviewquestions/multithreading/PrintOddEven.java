package org.advancedjava.interviewquestions.multithreading;

/*
1. Print Even and Odd Numbers Using Two Threads
Problem: Write a program where one thread prints even numbers (0, 2, 4, …) and another
prints odd numbers (1, 3, 5, …) up to 10, in sequence (0, 1, 2, 3, …).
Why Asked: Tests synchronization and inter-thread communication.

Explanation: Uses wait() and notify() to alternate between threads, ensuring sequence via synchronization.
 */
public class PrintOddEven {
    private int count = 0;
    private final int max = 10;

    public synchronized void printEven() throws InterruptedException {
        while (count < max) {
            if (count % 2 == 0) {
                System.out.println("Even Thread: " + count++);
                notify();
            } else {
                wait();
            }
        }
    }

    public synchronized void printOdd() throws InterruptedException {
        while (count < max) {
            if (count % 2 == 1) {
                System.out.println("Odd Thread: " + count++);
                notify();
            } else {
                wait();
            }
        }
    }

    public static void main(String[] args) {
        PrintOddEven printer = new PrintOddEven();

        Thread evenThread = new Thread(() -> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread oddThread = new Thread(() -> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        evenThread.start();
        oddThread.start();

    }
}
