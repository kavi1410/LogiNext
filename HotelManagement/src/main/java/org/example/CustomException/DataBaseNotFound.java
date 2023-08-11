package org.example.CustomException;

public class DataBaseNotFound extends Throwable {
    String message;

    public DataBaseNotFound(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "message = " + message;
    }
}
