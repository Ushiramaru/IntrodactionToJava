package mainTask_4.entity;

import java.util.ArrayList;
import java.util.Comparator;

public interface Present {

    Comparator SORT_PRESENT_BY_ASCENDING_WEIGTH = Comparator.comparingInt(Present::getWeight);
    Comparator SORT_PRESENT_BY_DESCENDING_WEIGTH = (present, t1) -> Integer.compare(((Present) t1).getWeight(), ((Present) present).getWeight());
    Comparator SORT_PRESENT_BY_ASCENDING_SUGAR_WEIGTH = Comparator.comparingInt(Present::getSugarWeight);
    Comparator SORT_PRESENT_BY_DESCENDING_SUGAR_WEIGTH = (pastry, t1) -> Integer.compare(((Present) t1).getSugarWeight(), ((Present) pastry).getSugarWeight());

    int getWeight();

    int getSugarWeight();

    void sortPresents(Comparator comparator);

    ArrayList<Pastry> findPastries(int minSugarWeight, int maxSugarWeight);

}