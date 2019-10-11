package mainTask_4.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public abstract class Pastry implements Present {

    @SerializedName("type")
    private String typeName;

    private String name;
    private int weight;
    private int sugarWeight;

    public Pastry(String name, int weight, int sugarWeight) {
        if (name == null) {
            throw new IllegalArgumentException("name can't be null");
        }
        if (weight < 1) {
            throw new IllegalArgumentException("weight must be positive");
        }
        if (sugarWeight < 0) {
            throw new IllegalArgumentException("sugarWeight can't be negative");
        }
        if (sugarWeight > weight) {
            throw new IllegalArgumentException("sugarWeight can't be more than weight");
        }
        this.typeName = getClass().getName();
        this.name = name;
        this.weight = weight;
        this.sugarWeight = sugarWeight;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getSugarWeight() {
        return sugarWeight;
    }

    @Override
    public void sortPresents(Comparator comparator) {

    }

    @Override
    public ArrayList<Pastry> findPastries(int minSugarWeight, int maxSugarWeight) {
        ArrayList<Pastry> pastries = new ArrayList<>();
        if (sugarWeight >= minSugarWeight && sugarWeight <= maxSugarWeight) {
            pastries.add(this);
        }
        return pastries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pastry pastry = (Pastry) o;
        return weight == pastry.weight &&
                sugarWeight == pastry.sugarWeight &&
                name.equals(pastry.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, sugarWeight);
    }

    @Override
    public String toString() {
        return "Pastry{" +
                "typeName='" + typeName + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", sugarWeight=" + sugarWeight +
                '}';
    }

}