package com.company;

public class Main {

    public static void main(String[] args) {
        final int CARS_ENABLE = 3;
        ThreadGroup groupCarDealership = new ThreadGroup("group");
        CarDealership shop = new CarDealership(CARS_ENABLE);
        Thread toyota = new Producer(groupCarDealership,"Toyota", shop);
        Thread consumer1 = new Consumer(groupCarDealership,"Покупатель 1", shop);
        Thread consumer2 = new Consumer(groupCarDealership,"Покупатель 2", shop);
        Thread consumer3 = new Consumer(groupCarDealership,"Покупатель 3", shop);
        Thread consumer4 = new Consumer(groupCarDealership,"Покупатель 4", shop);

        toyota.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();

        while (true) {
            if (shop.getCarsHaveBought() >= shop.getCARS_TO_SALE()) {
                break;
            }
        }
        groupCarDealership.interrupt();
    }
}
