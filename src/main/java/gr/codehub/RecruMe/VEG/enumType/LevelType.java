package gr.codehub.RecruMe.VEG.enumType;

/**
 * Enumerated type for education level consists of a set of named values/collection of constants with
 * the corresponding database value for each constant.
 */

public enum LevelType {
    JUNIOR(0),
    MID(1),
    SENIOR(2);

    private int dbValue;

    /**
     * Constructor for LevelType with
     * @param i defining database value
     */

    LevelType(int i) {
        this.dbValue = i;
    }
}

