package gr.codehub.RecruMe.VEG.exceptions;

/**
 * Constructs a new exception, called MatchedAlreadyException, thrown during the execution of a method,
 * with a specified message, when the job offer and applicant are already matched (are set as inactive).
 * Message: the description.
 */

public class MatchedAlreadyException extends Exception {
    public MatchedAlreadyException(String description){
        super(description);
    }
}
