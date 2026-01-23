package org.prepare;

/**
 *  Print Odd and Even Numbers Alternately Using Two Threads.
 */

public class AlternateNumsPrint {

    private final int max;
    private int current =1;
    private final Object lock = new Object();

    public AlternateNumsPrint(int max) {
        this.max = max;
    }

    public void printOdd() {
        synchronized (lock) {
            while (current < max) {
                while (current % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(current++);
                lock.notifyAll();
            }
        }
    }

    public void printEven() {
        synchronized (lock) {
            while (current < max) {
                while (current % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(current++);
                lock.notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        AlternateNumsPrint printer = new AlternateNumsPrint(10);
        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);

        oddThread.start();
        evenThread.start();
    }
}
