package ie.dit.slenderhealth.models;

/**
 * Created by c11428058 on 24/11/2016.
 */
public class Machine {

    private String name;
    private int minWeight;
    private int maxWeight;
    private int step;
    private Integer[] weights;

    public Machine(String name, int minWeight, int maxWeight, int step) {
        this.name = name;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.step = step;
        weights = calculateWeights();
    }

    public Integer[] getWeights() {
        return weights;
    }

    public String getName() {
        return name;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getStep() {
        return step;
    }

    private Integer[] calculateWeights(){
        int numWeights = (maxWeight-minWeight)/step + 1; //gets how many times step goes between min and maxWeight
        Integer[] weights = new Integer[numWeights];
        int newStep = minWeight;
        for(int i = 0; i < numWeights; i++){
            weights[i] = newStep;
            newStep += step;
        }
        return weights;
    }

    @Override
    public String toString() {
        return name;
    }
}
