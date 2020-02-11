package gr.codehub.RecruMe.VEG.models;

public enum MatchType {
    MANUAL(0),
    AUTOMATIC(1),
    FINALIZED(2);

    private int dbValue;

    MatchType(int i) {
        this.dbValue = i;
    }
}
