package org.advancedjava.interviewquestions.multithreading;

/*
5. Print “Ping Pong” Alternately with Two Threads
Problem: Two threads alternate printing “Ping” and “Pong” 5 times each, e.g., Ping, Pong, Ping, Pong, ….
Why Asked: Tests coordination similar to producer-consumer but simpler.

Explanation:
isPingTurn flag alternates turns; wait() and notify() enforce the sequence.
 */
class PingPong {
    private boolean isPingTurn = true;

    public synchronized void printPing() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            while (!isPingTurn) {
                wait();
            }
            System.out.println("Ping");
            isPingTurn = false;
            notify();
        }
    }

    public synchronized void printPong() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            while (isPingTurn) {
                wait();
            }
            System.out.println("Pong");
            isPingTurn = true;
            notify();
        }
    }
}

public class PingPongTest {
    public static void main(String[] args) {
        PingPong pp = new PingPong();
        Thread pingThread = new Thread(() -> {
            try {
                pp.printPing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread pongThread = new Thread(() -> {
            try {
                pp.printPong();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pingThread.start();
        pongThread.start();
    }
}
