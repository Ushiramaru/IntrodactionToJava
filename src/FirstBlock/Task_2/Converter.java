package FirstBlock.Task_2;

import java.math.BigDecimal;

public class Converter {

    public BigDecimal getMilligram(BigDecimal weight) {
        return weight.movePointRight(6);
    }

    public BigDecimal getGram(BigDecimal weight) {
        return weight.movePointRight(3);
    }

    public BigDecimal getTon(BigDecimal weight) {
        return weight.movePointRight(-3);
    }

}
