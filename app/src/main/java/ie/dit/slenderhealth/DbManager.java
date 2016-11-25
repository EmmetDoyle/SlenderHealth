package ie.dit.slenderhealth;

/**
 * Created by c11428058 on 25/11/2016.
 */
public class DbManager {

    public static final String KEY_ROWID        = "_id";
    public static final String KEY_NAME         = "name";
    public static final String KEY_WEIGHT       = "weight";
    public static final String KEY_SETS         = "sets";
    public static final String KEY_REPS         = "reps";
    public static final String KEY_MINWEIGHT    = "minWeight";
    public static final String KEY_MAXWEIGHT    = "maxWeight";
    public static final String KEY_STEP         = "step";

    private static final String DATABASE_NAME    = "Slender_Health";
    private static final String TABLE_WORKOUT    = "workout";
    private static final String TABLE_EXERCISE   = "exercise";
    private static final String TABLE_MACHINE    = "machine";

    private static final String CREATE_WORKOUT_TABLE =
            "create table " + TABLE_WORKOUT + " (" +
                    KEY_ROWID + "integer primary key autoincrement, " +
                    KEY_NAME + "text not null);";

    private static final String CREATE_MACHINE_TABLE =
            "create table " + TABLE_MACHINE + " (" +
                    KEY_ROWID + "integer primary key autoincrement, " +
                    KEY_NAME + "text not null, " +
                    KEY_MINWEIGHT + "integer not null, " +
                    KEY_MAXWEIGHT + "integer not null, " +
                    KEY_STEP + "integer not null);";

    //private static final String CREATE_EXERCISE_TABLE =
            //ToDO: Make exercise table
}
