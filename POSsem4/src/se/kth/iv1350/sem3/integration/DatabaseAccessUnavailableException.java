package se.kth.iv1350.sem3.integration;

/**
 * Thrown when a database could not be accessed.
 */
public class DatabaseAccessUnavailableException extends RuntimeException{
    /**
     * Constructs a new DataBaseAccessUnavailable exception with the specified message
     * @param message contains details about the exception.
     */
    public DatabaseAccessUnavailableException(String message){
        super(message);
    }

}
