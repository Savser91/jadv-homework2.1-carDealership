package com.company;

public class Producer extends Thread {
    private final long PRODUCER_DELAY = 3000;
    String name;
    private CarDealership shop;

    public Producer (ThreadGroup tg, String name, CarDealership shop) {
        super(name);
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted() && shop.getCarsHaveBought() < shop.getCARS_TO_SALE()) {
                shop.put();
                Thread.sleep(PRODUCER_DELAY);
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
