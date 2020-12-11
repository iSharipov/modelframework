package io.github.isharipov.modelframework;

/**
 * Common validation exception class
 */
public class ValidationException extends IllegalArgumentException {
    public ValidationException(String message) {
        super(message);
    }
}
