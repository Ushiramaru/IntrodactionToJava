package mainTask_1.firstBlock.task_2;

import java.math.BigDecimal;

public class Converter {

    private static final byte MILLIGRAM_MULTIPLIER = 6;
    private static final byte GRAM_MULTIPLIER = 3;
    private static final byte TON_MULTIPLIER = -3;

    public BigDecimal getMilligram(BigDecimal weight) {
        return weight.movePointRight(MILLIGRAM_MULTIPLIER);
    }

    public BigDecimal getGram(BigDecimal weight) {
        return weight.movePointRight(GRAM_MULTIPLIER);
    }

    public BigDecimal getTon(BigDecimal weight) {
        return weight.movePointRight(TON_MULTIPLIER);
    }

}