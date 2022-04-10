package by.epam.training.java.multithreading.logic;

import by.epam.training.java.multithreading.entity.Port;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class StorageManager extends Thread {
    private static final Logger logger = LogManager.getLogger(StorageManager.class);

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Port port;

    public StorageManager(Port port) {
        this.port = port;
    }

    @Override
    public void run() {
        while (true) {
            reentrantLock.lock();
            if (port.getStorage().get() < (Port.getInstance().getStorageCapacity() / 2)) {
                port.setStorage((Port.getInstance().getStorageCapacity() / 5) * 4);
            }

            reentrantLock.unlock();
            reentrantLock.lock();

            if (port.getStorage().get() > (Port.getInstance().getStorageCapacity() / 5) * 4) {
                port.setStorage(Port.getInstance().getStorageCapacity() / 10);
            }
            reentrantLock.unlock();

            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                logger.log(Level.ERROR, "Interrupted exception. Demon error.", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
