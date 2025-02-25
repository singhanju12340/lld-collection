package com.machineCode.designPatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 25/02/25 and 1:04 PM
 */
public class House implements Cloneable{
    int bedroom;
    int bathroom;
    List<String> features;

    public House(int bedroom, int bathroom) {
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.features = new ArrayList<>();
    }

    public void addFeature(String feature) {
        features.add(feature);
    }

    public int getRooms() {
        return bedroom;
    }

    public int getBathrooms() {
        return bathroom;
    }

    public List<String> getFeatures() {
        return features;
    }

    @Override
    public String toString() {
        return "House{" +
                "bedroom=" + bedroom +
                ", bathroom=" + bathroom +
                ", features=" + features +
                '}';
    }

    // Shallow copy implementation
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    // Deep copy implementation (if required)
    public House deepClone() {
        try {
            House cloned = (House) super.clone();
            // Create a new list for features to ensure deep copying.
            cloned.features = new ArrayList<>(this.features);
            return cloned;
        } catch (CloneNotSupportedException e) {
            // This should not happen because we are Cloneable.
            throw new AssertionError();
        }
    }

}
