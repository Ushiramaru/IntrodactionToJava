package mainTask_4.entity;

import mainTask_4.enums.Waffle;
import mainTask_4.enums.Wrapper;

import java.util.Objects;

public class WaffleCandy extends Candy {

    private Waffle waffle;

    public WaffleCandy(String name, int weight, int sugarWeight, Wrapper wrapper, Waffle waffle) {
        super(name, weight, sugarWeight, wrapper);
        if (waffle == null) {
            throw new IllegalArgumentException("waffle can't be null");
        }
        this.waffle = waffle;
    }

    public Waffle getWaffle() {
        return waffle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WaffleCandy that = (WaffleCandy) o;
        return waffle == that.waffle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), waffle);
    }

    @Override
    public String toString() {
        return "WaffleCandy{" +
                "waffle=" + waffle +
                "} " + super.toString();
    }

}