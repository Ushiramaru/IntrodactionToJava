package mainTask_4.entity;

import mainTask_4.enums.Wrapper;

import java.util.Objects;

public abstract class Candy extends Pastry {

    private Wrapper wrapper;

    public Candy(String name, int weight, int sugarWeight, Wrapper wrapper) {
        super(name, weight, sugarWeight);
        if (wrapper == null) {
            throw new IllegalArgumentException("wrapper can't be null");
        }
        this.wrapper = wrapper;
    }

    public Wrapper getWrapper() {
        return wrapper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candy candy = (Candy) o;
        return wrapper == candy.wrapper;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wrapper);
    }

    @Override
    public String toString() {
        return "Candy{" +
                "wrapper=" + wrapper +
                "} " + super.toString();
    }

}