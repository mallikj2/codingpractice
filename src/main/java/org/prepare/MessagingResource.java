package org.prepare;


class MessagingResource {
    private int value;
    private boolean hasValue = false;


    public synchronized void produce(int val) throws InterruptedException {
        while (hasValue) {
            wait();
        }
        value = val;
        hasValue = true;
        System.out.println("Produced: " + val);
        notify();
    }


    public synchronized int consume() throws InterruptedException {
        while (!hasValue) {
            wait();
        }
        int consumedValue = value;
        hasValue = false;
        System.out.println("Consumed: " + consumedValue);
        notify();
        return consumedValue;
    }

    public static void main(String[] args) {
        MessagingResource resource = new MessagingResource();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int randomNumber = (int) (Math.random() * 100);
                    resource.produce(randomNumber);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    resource.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}