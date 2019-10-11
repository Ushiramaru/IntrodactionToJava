package mainTask_4.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Gift implements Present {

    @SerializedName("type")
    private String typeName;

    private ArrayList<Present> presents;

    public Gift(ArrayList<Present> presents) {
        if (presents == null) {
            presents = new ArrayList<>();
        }
        if (presents.contains(null)) {
            throw new NullPointerException("presents can't contains null elements");
        }
        this.typeName = getClass().getName();
        this.presents = presents;
    }

    public ArrayList<Present> getPresents() {
        return presents;
    }

    @Override
    public int getWeight() {
        int weight = 0;
        for (Present present : presents) {
            weight += present.getWeight();
        }
        return weight;
    }

    @Override
    public int getSugarWeight() {
        int sugarWeight = 0;
        for (Present present : presents) {
            sugarWeight += present.getSugarWeight();
        }
        return sugarWeight;
    }

    @Override
    public void sortPresents(Comparator comparator) {
        presents.sort(comparator);
        for (Present present : presents) {
            present.sortPresents(comparator);
        }
    }

    @Override
    public ArrayList<Pastry> findPastries(int minSugarWeight, int maxSugarWeight) {
        ArrayList<Pastry> pastries = new ArrayList<>();
        for (Present present : presents) {
            pastries.addAll(present.findPastries(minSugarWeight, maxSugarWeight));
        }
        return pastries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return typeName.equals(gift.typeName) &&
                presents.equals(gift.presents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName, presents);
    }

    @Override
    public String toString() {
        return "Gift{" +
                "typeName='" + typeName + '\'' +
                ", presents=" + presents +
                '}';
    }

}
