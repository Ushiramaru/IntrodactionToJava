package SecondBlock.Task_2;

public class Dragon {

    private static final int eyesOnHead = 2;
    private static final int headBefore_200 = 3;
    private static final int headBefore_300 = 2;
    private static final int headAfter_300 = 1;


    private int headCount = 3;
    private int eyesCount;
    private int age;

    public Dragon(int age) {
        this.age = age;
        calculateHead();
        eyesCount = headCount*eyesOnHead;
    }

    public int getHeadCount() {
        return headCount;
    }

    private void calculateHead() {
        if (age <= 200) {
            headCount += headBefore_200*age;
        } else {
            if (age <= 300) {
                headCount += headBefore_200*200+headBefore_300*(age-200);
            } else {
                headCount += headBefore_200*200+headBefore_300*100+headAfter_300*(age-300);
            }
        }
    }

    public int getEyesCount() {
        return eyesCount;
    }
}
