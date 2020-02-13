package gr.codehub.RecruMe.VEG.exceptions;

/**
 * Constructs a new exception, called SkillNotFoundException, thrown during the execution of a method,
 * with a specified message, when no skill is found.
 * Message: the description.
 */

public class SkillNotFoundException extends Exception {
        public SkillNotFoundException(String description) {
        super(description);
    }
}
