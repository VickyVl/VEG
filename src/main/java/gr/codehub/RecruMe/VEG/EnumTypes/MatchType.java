package gr.codehub.RecruMe.VEG.EnumTypes;

/**
 * Enumerated type for match type consists of a set of named values/collection of constants with
 * the corresponding database value for each constant.
 */

public enum MatchType {
    MANUAL(0),
    AUTOMATIC(1),
    FINALIZED(2);

    private int dbValue;

    /**
     * Constructor for MatchType with
     * @param i defining database value
     */

    MatchType(int i) {
        this.dbValue = i;
    }
}
