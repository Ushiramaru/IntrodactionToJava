package mainTask_4.entity;

import mainTask_4.enums.Chocolate;
import mainTask_4.enums.Wrapper;

import java.util.Objects;

public class ChocolateCandy extends Candy {

    private Chocolate chocolate;

    public ChocolateCandy(String name, int weight, int sugarWeight, Wrapper wrapper, Chocolate chocolate) {
        super(name, weight, sugarWeight, wrapper);
        if (chocolate == null) {
            throw new IllegalArgumentException("chocolate can't be null");
        }
        this.chocolate = chocolate;
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChocolateCandy that = (ChocolateCandy) o;
        return chocolate == that.chocolate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chocolate);
    }

    @Override
    public String toString() {
        return "ChocolateCandy{" +
                "chocolate=" + chocolate +
                "} " + super.toString();
    }

}
