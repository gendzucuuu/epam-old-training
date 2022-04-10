package by.epam.training.java.multithreading.entity;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private static final int BERTH_COUNT = 10;
    private static final int STORAGE_CAPACITY = 200;

    private Berth[] berths;
    private AtomicInteger storage;

    private static Port instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    private Port() {
        this.berths = new Berth[BERTH_COUNT];

        for (Berth berth : berths) {
            berth = new Berth();
        }

        this.storage = new AtomicInteger();
        storage.set(0);
    }

    public static Port getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new Port();
            }
        } finally {
            lock.unlock();
        }

        return instance;
    }

    public int getStorageCapacity() {
        return STORAGE_CAPACITY;
    }

    public int getBerthCount() {
        return BERTH_COUNT;
    }

    public Berth[] getBerths() {
        return berths;
    }

    public void setBerths(Berth[] berths) {
        this.berths = berths;
    }

    public AtomicInteger getStorage() {
        return storage;
    }

    public void setStorage(int newStorage) {
        this.storage.set(newStorage);
    }

}
