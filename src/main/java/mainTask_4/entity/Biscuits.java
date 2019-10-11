package mainTask_4.entity;

import mainTask_4.enums.Filling;

import java.util.Objects;

public class Biscuits extends Pastry {

    private Filling filling;

    public Biscuits(String name, int weight, int sugarWeight, Filling filling) {
        super(name, weight, sugarWeight);
        if (filling == null) {
            throw new IllegalArgumentException("filling can't be null");
        }
        this.filling = filling;
    }

    public Filling getFilling() {
        return filling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Biscuits biscuits = (Biscuits) o;
        return filling == biscuits.filling;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), filling);
    }

    @Override
    public String toString() {
        return "Biscuits{" +
                "filling=" + filling +
                "} " + super.toString();
    }

}
