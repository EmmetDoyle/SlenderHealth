package ie.dit.slenderhealth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by c11428058 on 25/11/2016.
 */
public class DbManager {

    public static final String KEY_ROWID            = "_id";
    public static final String KEY_W_NAME           = "w_name";
    public static final String KEY_EQUIP_NAME       = "equip_name";
    public static final String KEY_WEIGHT           = "weight";
    public static final String KEY_SETS             = "sets";
    public static final String KEY_REPS             = "reps";
    public static final String KEY_MINWEIGHT        = "minWeight";
    public static final String KEY_MAXWEIGHT        = "maxWeight";
    public static final String KEY_STEP             = "step";

    private static final String DATABASE_NAME       = "Slender_Health";
    private static final String TABLE_WORKOUT       = "workout";
    private static final String TABLE_EXERCISE      = "exercise";
    private static final String TABLE_MACHINE       = "machine";
    private static final int DATABASE_VERSION       = 1;

    private static final String CREATE_MACHINE_TABLE =
            "create table " + TABLE_MACHINE + " (" +
                    KEY_ROWID + "integer primary key autoincrement, " +
                    KEY_EQUIP_NAME + "text not null, " +
                    KEY_MINWEIGHT + "integer not null, " +
                    KEY_MAXWEIGHT + "integer not null, " +
                    KEY_STEP + "integer not null);";

    private static final String CREATE_WORKOUT_TABLE =
            "create table " + TABLE_WORKOUT + " (" +
                    KEY_ROWID + "integer primary key autoincrement, " +
                    KEY_EQUIP_NAME + "text not null foreign key, " +
                    KEY_W_NAME + "text not null);";

    private static final String CREATE_EXERCISE_TABLE =
            "create table " + TABLE_EXERCISE + " (" +
                    KEY_ROWID + "integer primary key autoincrement, " +
                    KEY_EQUIP_NAME + "text not null foreign key, " +
                    KEY_WEIGHT + "integer not null, " +
                    KEY_REPS + "integer not null, " +
                    KEY_SETS + "integer not null);";


    //private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_WORKOUT_TABLE);
            db.execSQL(CREATE_MACHINE_TABLE);
            db.execSQL(CREATE_EXERCISE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            //for later versions
        }
    }


    public DbManager open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        DBHelper.close();
    }

}
