package mainTask_2.task_1;

import java.util.Random;

public class HeadsOrTails {

    private int throwCount;
    private int heads;
    private int tails;
    private Random random;

    public HeadsOrTails(int throwCount) {
        if (throwCount < 0) {
            throw new IllegalArgumentException("throwCount can't be negative");
        }
        this.throwCount = throwCount;
        heads = 0;
        tails = 0;
        random = new Random();
        throwCoin(throwCount);
    }

    private void throwCoin(int throwCount) {
        while (throwCount > 0) {
            if (random.nextInt(2) == 0) {
                tails++;
            } else {
                heads++;
            }
            throwCount--;
        }
    }

    public void throwMore(int throwCount) {
        if (throwCount < 0) {
            throw new IllegalArgumentException("throwCount can't be negative");
        }
        this.throwCount += throwCount;
        throwCoin(throwCount);
    }

    public int getThrowCount() {
        return throwCount;
    }

    public int getHeads() {
        return heads;
    }

    public int getTails() {
        return tails;
    }

    public void reset() {
        throwCount = 0;
        heads = 0;
        tails = 0;
    }

}
