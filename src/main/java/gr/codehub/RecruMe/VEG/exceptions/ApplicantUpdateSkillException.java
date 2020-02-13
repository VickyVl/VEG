package gr.codehub.RecruMe.VEG.exceptions;

/**
 * Constructs a new exception, called ApplicantUpdateSkillException, thrown during the execution of a method,
 * with a specified message, when no skill is found.
 * Message: the description.
 */

public class ApplicantUpdateSkillException extends Exception{
    public ApplicantUpdateSkillException(String description){
        super(description);
    }
}