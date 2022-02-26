package com.company;

import java.util.concurrent.locks.*;

public class CarDealership {
    Lock lock = new ReentrantLock();
    Condition condition;
    private int carsEnable = 0;
    private int carsHaveBought = 0;
    private final int CARS_TO_SALE = 10;

    public CarDealership(int carsEnable) {
        this.carsEnable = carsEnable;
    }

    public synchronized void get() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            if (carsEnable == 0) {
                System.out.println("Машин нет");
            }
            while (carsEnable == 0) {
                condition.await();
            }
            carsHaveBought++;
            carsEnable--;
            System.out.println(Thread.currentThread().getName() + " купил 1 автомобиль");
            System.out.println("Машин продано - " + carsHaveBought);
            System.out.println("Машин на складе - " + carsEnable);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void put() {
        try {
            lock.lock();
            carsEnable++;
            System.out.println(Thread.currentThread().getName() + " выпустил 1 автомобиль");
            System.out.println("Машин на складе - " + carsEnable);
            condition.signal();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            lock.unlock();
        }
    }

    public int getCARS_TO_SALE() {
        return CARS_TO_SALE;
    }

    public int getCarsHaveBought() {
        return carsHaveBought;
    }
}
