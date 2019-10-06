package mainTask_4;

import java.util.Comparator;

public final class PresentsComparator {

    public static final Comparator SORT_PRESENT_BY_ASCENDING_WEIGTH = Comparator.comparingInt(Present::getWeight);
    public static final Comparator SORT_PRESENT_BY_DESCENDING_WEIGTH = (present, t1) -> Integer.compare(((Present)t1).getWeight(), ((Present)present).getWeight());
    public static final Comparator SORT_PRESENT_BY_ASCENDING_SUGAR_WEIGTH = Comparator.comparingInt(Present::getSugarWeight);
    public static final Comparator SORT_PRESENT_BY_DESCENDING_SUGAR_WEIGTH = (pastry, t1) -> Integer.compare(((Present)t1).getSugarWeight(), ((Present)pastry).getSugarWeight());

}
