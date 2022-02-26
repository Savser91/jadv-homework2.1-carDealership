package com.company;

public class CarDealership {
    private int carsEnable = 0;
    private int carsHaveBought = 0;
    private final int CARS_TO_SALE = 10;

    public CarDealership(int carsEnable) {
        this.carsEnable = carsEnable;
    }

    public synchronized void get() {
        System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
        while (carsEnable < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carsHaveBought++;
        carsEnable--;
        System.out.println(Thread.currentThread().getName() + " купил 1 автомобиль");
        System.out.println("Машин продано - " + carsHaveBought);
        System.out.println("Машин на складе - " + carsEnable);
        notify();
    }

    public synchronized void put() {
        while (carsEnable >= CARS_TO_SALE) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carsEnable++;
        System.out.println(Thread.currentThread().getName() + " выпустил 1 автомобиль");
        System.out.println("Машин на складе - " + carsEnable);
        notify();
    }

    public int getCARS_TO_SALE() {
        return CARS_TO_SALE;
    }

    public int getCarsHaveBought() {
        return carsHaveBought;
    }
}
