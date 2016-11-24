package ie.dit.slenderhealth;

/**
 * Created by c11428058 on 24/11/2016.
 */
public class Workout {

    String name;

    Workout(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
