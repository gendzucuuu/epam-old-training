package by.epam.training.java.multithreading.controller;

import by.epam.training.java.multithreading.entity.Port;
import by.epam.training.java.multithreading.entity.Ship;
import by.epam.training.java.multithreading.logic.PortManager;
import by.epam.training.java.multithreading.logic.StorageManager;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final Port PORT = Port.getInstance();
    private static final Semaphore SEMAPHORE = new Semaphore(PORT.getBerthCount(), true);
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static PortManager portManager = new PortManager(SEMAPHORE, PORT);



    public static void main(String[] args) {
        List<Callable<Integer>> callable = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            callable.add(new Ship((int) (Math.random()*10+2), false, portManager));
        }

        try {
            StorageManager storageManager = new StorageManager(PORT);
            storageManager.setDaemon(true);
            storageManager.start();
            executorService.invokeAll(callable);
            executorService.shutdown();
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, "Interrupted exception.", e);
        }
    }
}
