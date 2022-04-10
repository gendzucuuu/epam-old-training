package by.epam.training.java.multithreading.logic;

import by.epam.training.java.multithreading.entity.Port;
import by.epam.training.java.multithreading.entity.Ship;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class PortManager {
    private static final Logger logger = LogManager.getLogger(PortManager.class);

    private Semaphore semaphore;
    private ReentrantLock reentrantLock = new ReentrantLock();

    private Port port;

    public PortManager(Semaphore semaphore, Port port) {
        this.semaphore = semaphore;
        this.port = port;
    }

    public void loadShip(Ship ship) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, "Interrupted exception.", e);
            Thread.currentThread().interrupt();
        }
        reentrantLock.lock();

        int i = 0;
        boolean temp = false;

        while (!temp && i < port.getBerths().length) {
            if (!port.getBerths()[i].isBusy().get()) {
                port.getBerths()[i].setBusy(true);
                ship.setBerthNumber(i);
                temp = true;
            }

            i++;
        }
        reentrantLock.unlock();

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            logger.log(Level.INFO, "Load ship failed.");
            logger.log(Level.ERROR, "Interrupted exception.", e);
            Thread.currentThread().interrupt();
        }
    }

    public void sendShip(Ship ship) {
        reentrantLock.lock();
        if (ship.getCountOfMinerals().get() > (Port.getInstance().getStorageCapacity()) / 2) {
            port.getBerths()[ship.getBerthNumber().get()].setBusy(false);
            reentrantLock.unlock();
            semaphore.release();
        }
        else {
            if (ship.isFull().get()) {
                if ((Port.getInstance().getStorageCapacity() - port.getStorage().get()) >=
                        ship.getCountOfMinerals().get()) {
                    port.setStorage(port.getStorage().get() + ship.getCountOfMinerals().get());
                    ship.getCountOfMinerals().set(0);
                    port.getBerths()[ship.getBerthNumber().get()].setBusy(false);
                    reentrantLock.unlock();
                    semaphore.release();
                } else {
                    try {
                        TimeUnit.MILLISECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        logger.log(Level.ERROR, "Interrupted exception. Error with + " +
                                Thread.currentThread().getName(),  e);

                    }
                    reentrantLock.unlock();
                    sendShip(ship);
                }
            } else {
                if (port.getStorage().get() >= ship.getCountOfMinerals().get()) {
                    port.setStorage(port.getStorage().get() - ship.getCountOfMinerals().get());
                    ship.getCountOfMinerals().set(0);
                    port.getBerths()[ship.getBerthNumber().get()].setBusy(false);
                    reentrantLock.unlock();
                    semaphore.release();
                } else {
                    reentrantLock.unlock();
                    try {
                        TimeUnit.MILLISECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        logger.log(Level.ERROR, "Interrupted exception. Error with: " +
                                Thread.currentThread().getName(), e);

                    }
                    sendShip(ship);
                }
            }
        }
    }
}
