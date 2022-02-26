package com.company;

public class Consumer extends Thread {
    String name;
    private CarDealership shop;
    private final long CONSUMER_DELAY = 1000;

    public Consumer(ThreadGroup tg, String name, CarDealership shop) {
        super(name);
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted() && shop.getCarsHaveBought() < shop.getCARS_TO_SALE()) {
                shop.get();
                Thread.sleep(CONSUMER_DELAY);
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
