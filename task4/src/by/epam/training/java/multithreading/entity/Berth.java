package by.epam.training.java.multithreading.entity;

import by.epam.training.java.multithreading.generator.IdGenerator;

import java.util.concurrent.atomic.AtomicBoolean;

public class Berth {
    private long berthId;
    private AtomicBoolean isBusy;

    public Berth() {
        this.berthId = IdGenerator.generateId();
        this.isBusy = new AtomicBoolean(false);
    }

    public Berth(AtomicBoolean status) {
        this.berthId = IdGenerator.generateId();
        this.isBusy = status;
    }

    public long getBerthId() {
        return berthId;
    }

    public void setBerthId(long berthId) {
        this.berthId = berthId;
    }

    public AtomicBoolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean newStatus) {
        this.isBusy.set(newStatus);
    }
}
