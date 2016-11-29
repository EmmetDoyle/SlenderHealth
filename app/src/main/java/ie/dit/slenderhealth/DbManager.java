package ie.dit.slenderhealth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import ie.dit.slenderhealth.models.Exercise;
import ie.dit.slenderhealth.models.Machine;

/**
 * Created by c11428058 on 25/11/2016.
 */
public class DbManager {

    public static final String KEY_ROWID            = "_id";
    public static final String KEY_MACHINE          = "machine";
    public static final String KEY_WORKOUT          = "workout";
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
                    KEY_ROWID + " integer primary key autoincrement, " +
                    KEY_EQUIP_NAME + " text not null, " +
                    KEY_MINWEIGHT + " integer not null, " +
                    KEY_MAXWEIGHT + " integer not null, " +
                    KEY_STEP + " integer not null);";

    private static final String CREATE_WORKOUT_TABLE =
            "create table " + TABLE_WORKOUT + " (" +
                    KEY_ROWID + " integer primary key autoincrement, " +
                    KEY_W_NAME + " text not null);";

    private static final String CREATE_EXERCISE_TABLE =
            "create table " + TABLE_EXERCISE + " (" +
                    KEY_ROWID + " integer primary key autoincrement, " +
                    KEY_MACHINE + " integer not null, " +
                    KEY_WORKOUT + " integer not null, " +
                    KEY_WEIGHT + " integer not null, " +
                    KEY_REPS + " integer not null, " +
                    KEY_SETS + " integer not null, " +
                    "FOREIGN KEY(" + KEY_MACHINE + ") REFERENCES " + TABLE_MACHINE + "(" + KEY_ROWID + "), " +
                    "FOREIGN KEY(" + KEY_WORKOUT + ") REFERENCES " + TABLE_WORKOUT + "(" + KEY_ROWID + "));";


    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DbManager(Context ctx){
        this.context = ctx;
        DBHelper = new DatabaseHelper(context, this);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DbManager manager;
        DatabaseHelper(Context context, DbManager manager){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.manager = manager;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_WORKOUT_TABLE);
            db.execSQL(CREATE_MACHINE_TABLE);
            db.execSQL(CREATE_EXERCISE_TABLE);

            Machine[] machines = {
                    new Machine("Shoulder Press", 20, 200, 20, 0),
                    new Machine("Leg Curler", 10, 150, 10, 0),
                    new Machine("Bicep Curler", 20, 140, 5, 0),
                    new Machine("Squat Machine", 40, 300, 20, 0)
            };

            for(int i = 0; i < machines.length; i++) {

                ContentValues initialValues = new ContentValues();
                initialValues.put(KEY_EQUIP_NAME, machines[i].getName());
                initialValues.put(KEY_MINWEIGHT, machines[i].getMinWeight());
                initialValues.put(KEY_MAXWEIGHT, machines[i].getMaxWeight());
                initialValues.put(KEY_STEP, machines[i].getStep());
                db.insert(TABLE_MACHINE, null, initialValues);
            }
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

    public Cursor getAllMachines(){
        Cursor cursor = db.query(TABLE_MACHINE, new String[] {
                    KEY_ROWID,
                    KEY_EQUIP_NAME,
                    KEY_MINWEIGHT,
                    KEY_MAXWEIGHT,
                    KEY_STEP},
                null,
                null,
                null,
                null,
                null
        );

        return cursor;
    }

    public Cursor getAllWorkouts(){
        Cursor cursor = db.query(TABLE_WORKOUT, new String[] {
                        KEY_ROWID,
                        KEY_W_NAME},
                null,
                null,
                null,
                null,
                null
        );

        return cursor;
    }

    public long insertWorkout(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_W_NAME, name);
        return db.insert(TABLE_WORKOUT, null, contentValues);
    }


    public long insertExercise(int weight, int reps, int sets, int machine, int workout){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_WEIGHT, weight);
        contentValues.put(KEY_REPS, reps);
        contentValues.put(KEY_SETS, sets);
        contentValues.put(KEY_MACHINE, machine);
        contentValues.put(KEY_WORKOUT, workout);
        return db.insert(TABLE_EXERCISE, null, contentValues);
    }
}
