package by.epam.training.java.triangle.exception;

public class DataFormatException extends Exception{
    public DataFormatException() {
        super();
    }

    public DataFormatException(String message) {
        super(message);
    }

    public DataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFormatException(Throwable cause) {
        super(cause);
    }
}
