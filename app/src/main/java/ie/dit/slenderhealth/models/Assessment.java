package ie.dit.slenderhealth.models;

/**
 * Created by c11428058 on 28/11/2016.
 */
public class Assessment {
    private String date;
    private float height;
    private float weight;
    private float bmi;
    private float bodyFat;
    private float chest;
    private float waist;
    private float tummy;
    private float hips;
    private float thigh;
    private float calf;
    private float bicep;

    public Assessment(String date, float height, float weight, float bodyFat, float chest, float waist, float tummy, float hips, float thigh, float calf, float bicep) {
        this.date = date;
        this.height = height;
        this.weight = weight;
        this.bodyFat = bodyFat;
        this.chest = chest;
        this.waist = waist;
        this.tummy = tummy;
        this.hips = hips;
        this.thigh = thigh;
        this.calf = calf;
        this.bicep = bicep;

        bmi = calculateBmi(height, weight);
    }

    public float calculateBmi(float height, float weight){
        return weight/(height*height);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public float getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(float bodyFat) {
        this.bodyFat = bodyFat;
    }

    public float getChest() {
        return chest;
    }

    public void setChest(float chest) {
        this.chest = chest;
    }

    public float getWaist() {
        return waist;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public float getTummy() {
        return tummy;
    }

    public void setTummy(float tummy) {
        this.tummy = tummy;
    }

    public float getHips() {
        return hips;
    }

    public void setHips(float hips) {
        this.hips = hips;
    }

    public float getThigh() {
        return thigh;
    }

    public void setThigh(float thigh) {
        this.thigh = thigh;
    }

    public float getCalf() {
        return calf;
    }

    public void setCalf(float calf) {
        this.calf = calf;
    }

    public float getBicep() {
        return bicep;
    }

    public void setBicep(float bicep) {
        this.bicep = bicep;
    }

    @Override
    public String toString() {
        return date;
    }
}
