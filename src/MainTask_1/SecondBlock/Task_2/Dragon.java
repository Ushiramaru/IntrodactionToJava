package MainTask_1.SecondBlock.Task_2;

public class Dragon {

    private static final byte EYES_ON_HEAD = 2;
    private static final byte HEAD_BEFORE_200 = 3;
    private static final byte HEAD_BEFORE_300 = 2;
    private static final byte HEAD_AFTER_300 = 1;
    private static final short YOUNG_AGE = 200;
    private static final short MIDDLE_AGE = 300;

    private int headCount = 3;
    private int eyesCount;
    private int age;

    public Dragon(int age) {
        this.age = age;
        calculateHead();
        eyesCount = headCount * EYES_ON_HEAD;
    }

    public int getHeadCount() {
        return headCount;
    }

    private void calculateHead() {
        if (age <= YOUNG_AGE) {
            headCount += HEAD_BEFORE_200 * age;
        } else {
            if (age <= MIDDLE_AGE) {
                headCount += HEAD_BEFORE_200 * MIDDLE_AGE + HEAD_BEFORE_300 * (age - YOUNG_AGE);
            } else {
                headCount += HEAD_BEFORE_200 * YOUNG_AGE + HEAD_BEFORE_300 * (MIDDLE_AGE - YOUNG_AGE) + HEAD_AFTER_300 *(age - MIDDLE_AGE);
            }
        }
    }

    public int getEyesCount() {
        return eyesCount;
    }

}