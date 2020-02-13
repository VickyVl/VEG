package gr.codehub.RecruMe.VEG.exceptions;

/**
 * Constructs a new exception, called JobOfferNotFoundException, thrown during the execution of a method,
 * with a specified message, when no job offer is found.
 * Message: the description.
 */

public class JobOfferNotFoundException  extends Exception {
    public JobOfferNotFoundException(String description) {
        super(description);
    }
}
