package ie.dit.slenderhealth.models;

/**
 * Created by c11428058 on 25/11/2016.
 */
public class Exercise {
    private int weight;
    private int reps;
    private int sets;
    private long _id;


    //used when user creates workout
    public Exercise(int weight, int reps, int sets) {
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;
    }

    //used when getting workout from dB
    public Exercise(int weight, int reps, int sets, long _id) {
        this(weight, reps, sets);
        this._id = _id;

    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }


}
