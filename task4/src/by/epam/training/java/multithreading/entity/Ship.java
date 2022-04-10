package by.epam.training.java.multithreading.entity;

import by.epam.training.java.multithreading.generator.IdGenerator;
import by.epam.training.java.multithreading.logic.PortManager;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Ship implements Callable<Integer> {
    private static final int MAX_COUNT_OF_MINERALS = 20;

    private long shipId;
    private AtomicInteger countOfMinerals = new AtomicInteger();
    private AtomicBoolean isFull = new AtomicBoolean();
    private AtomicInteger berthNumber = new AtomicInteger();
    private PortManager portManager;

    public Ship() {
        this.shipId = IdGenerator.generateId();
        this.countOfMinerals.set(MAX_COUNT_OF_MINERALS);
        this.isFull.set(true);
    }

    public Ship(int countOfMinerals, boolean isFull, PortManager portManager) {
        this.shipId = IdGenerator.generateId();

        this.countOfMinerals.set(countOfMinerals);
        this.isFull.set(isFull);

//        if (countOfMinerals >= MAX_COUNT_OF_MINERALS || countOfMinerals < 1) {
//            this.countOfMinerals.set(MAX_COUNT_OF_MINERALS);
//            this.isFull.set(true);
//        }
//        else {
//            this.countOfMinerals.set(countOfMinerals);
//            this.isFull.set(false);
//        }

        this.portManager = portManager;
    }


    @Override
    public Integer call() throws Exception {
        int i = countOfMinerals.get();

        portManager.loadShip(this);
        portManager.sendShip(this);
        //leave ship

        return i;
    }

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }

    public AtomicInteger getCountOfMinerals() {
        return countOfMinerals;
    }

    public void setCountOfMinerals(int countOfMinerals) {
        if (countOfMinerals > MAX_COUNT_OF_MINERALS || countOfMinerals < 1) {
            this.countOfMinerals.set(MAX_COUNT_OF_MINERALS);
            this.isFull.set(true);
        }
        else {
            this.countOfMinerals.set(countOfMinerals);
            this.isFull.set(false);
        }
    }

    public AtomicBoolean isFull() {
        return isFull;
    }

    public AtomicInteger getBerthNumber() {
        return berthNumber;
    }

    public void setBerthNumber(int berthNumber) {
        this.berthNumber.set(berthNumber);
    }
}
