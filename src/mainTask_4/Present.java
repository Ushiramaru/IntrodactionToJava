package mainTask_4;

import mainTask_4.entity.Pastry;

import java.util.ArrayList;
import java.util.Comparator;

public interface Present {

    int getWeight();

    int getSugarWeight();

    void sortPresents(Comparator comparator);

    ArrayList<Pastry> findPastries(int minSugarWeight, int maxSugarWeight);

}
