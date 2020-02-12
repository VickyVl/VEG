package gr.codehub.RecruMe.VEG.EnumTypes;

public enum LevelType {
    JUNIOR(0),
    MID(1),
    SENIOR(2);

    private int dbValue;

    LevelType(int i) {
        this.dbValue = i;
    }
}

