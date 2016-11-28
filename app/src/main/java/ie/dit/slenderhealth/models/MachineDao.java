package ie.dit.slenderhealth.models;

import android.database.Cursor;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ie.dit.slenderhealth.DbManager;

/**
 * Created by c11428058 on 28/11/2016.
 */
public class MachineDao {

    private DbManager manager;

    /*public Machine[] getAllMachines() {
        //   call getAllMachines on the manager
        Cursor cursor = manager.getAllMachines();
        //   loop over the returned cursor
        //   At each loop create a Machine object from the cursor data
        Machine[] machines;
        for(int i = 0; i < cursor.getCount(); i++){
            String name = cursor.getColumnIndex(0);
            int minWeight = cursor.getColumnCount(1);
            int maxWeight = cursor.getColumnCount(2);
            int step = cursor.getColumnIndex(3);
            machines[i] = new Machine(name, minWeight, maxWeight, step);
        }
        //   Add Machine object to array/list
        //   return array/list
        return machines;
    }*/



}
