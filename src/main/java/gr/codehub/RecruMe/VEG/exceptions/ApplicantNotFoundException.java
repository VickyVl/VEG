package gr.codehub.RecruMe.VEG.exceptions;

/**
 * Constructs a new exception, called ApplicantNotFoundException, thrown during the execution of a method,
 * with a specified message, when no applicant is found.
 * Message: the description.
 */

public class ApplicantNotFoundException extends Exception{
    public ApplicantNotFoundException(String description){
        super(description);
    }
}
