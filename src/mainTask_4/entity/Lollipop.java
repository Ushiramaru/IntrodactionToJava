package mainTask_4.entity;

import mainTask_4.enums.Wrapper;

import java.util.Objects;

public class Lollipop extends Candy {

    private boolean isWithStick;

    public Lollipop(String name, int weight, int sugarWeight, Wrapper wrapper, boolean isWithStick) {
        super(name, weight, sugarWeight, wrapper);
        this.isWithStick = isWithStick;
    }

    public boolean isWithStick() {
        return isWithStick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Lollipop lollipop = (Lollipop) o;
        return isWithStick == lollipop.isWithStick;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isWithStick);
    }

}
