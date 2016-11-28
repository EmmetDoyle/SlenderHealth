package ie.dit.slenderhealth.models;

import android.content.Context;
import android.database.Cursor;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ie.dit.slenderhealth.DbManager;

/**
 * Created by c11428058 on 28/11/2016.
 */
public class MachineDao {

    private DbManager manager;

    public MachineDao(Context context) {
        this.manager = new DbManager(context);
    }

    public Machine[] getAllMachines() {
        //   call getAllMachines on the manager
        manager.open();
        Cursor cursor = manager.getAllMachines();
        //   loop over the returned cursor
        //   At each loop create a Machine object from the cursor data
        Machine[] machines = new Machine[4];

        cursor.moveToFirst();
        int i = 0;
        while (!cursor.isAfterLast()){
            String name = cursor.getString(cursor.getColumnIndex(DbManager.KEY_EQUIP_NAME));
            int minWeight = cursor.getInt(cursor.getColumnIndex(DbManager.KEY_MINWEIGHT));
            int maxWeight = cursor.getInt(cursor.getColumnIndex(DbManager.KEY_MAXWEIGHT));
            int step = cursor.getInt(cursor.getColumnIndex(DbManager.KEY_STEP));
            int id = cursor.getInt(0);

            machines[i++] = new Machine(name, minWeight, maxWeight, step, id);
            cursor.moveToNext();
        }

        manager.close();

        //   Add Machine object to array/list
        //   return array/list
        return machines;
    }



}
