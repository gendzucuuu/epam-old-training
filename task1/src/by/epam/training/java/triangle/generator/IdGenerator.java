package by.epam.training.java.triangle.generator;

public class IdGenerator {
    private static final long MIN_ID = 1;
    private static final long MAX_ID = 100_000;

    private static long id;

    private IdGenerator() {
    }

    public static long generateId() {
        ++id;

        if (MIN_ID + id >= MAX_ID) {
            id = 1;
        }

        return id;
    }

    public static void setupNewId(long newId) {
        id = newId;
    }
}
