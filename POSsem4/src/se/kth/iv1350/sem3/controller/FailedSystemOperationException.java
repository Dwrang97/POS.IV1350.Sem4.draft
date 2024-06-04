package se.kth.iv1350.sem3.controller;

/**
 * Thrown when a failed system operation occurs.
 */
public class FailedSystemOperationException extends Exception {
    /**
     * Constructs a new FailedSystemOperationException exception with the specified message and cause.
     * @param message the message containing details about the exception.
     * @param exception the cause for the exception.
     */
    public FailedSystemOperationException(String message, Exception exception){
        super(message, exception);
    }
}
