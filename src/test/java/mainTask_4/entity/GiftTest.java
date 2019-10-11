package mainTask_4.entity;

import mainTask_4.enums.Chocolate;
import mainTask_4.enums.Wrapper;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GiftTest {

    private static final int GIFT_WEIGHT = 70;
    private static final int GIFT_SUGAR_WEIGHT = 30;
    private static final int GIFT_FIND_PASTRIES = 4;

    private static Gift gift;

    @BeforeClass
    public static void beforeClass() {
        ArrayList<Present> presents = new ArrayList<>();
        presents.add(new ChocolateCandy("ChocolateCandy_20_10", 20, 10, Wrapper.FOIL, Chocolate.DARK));
        presents.add(new ChocolateCandy("ChocolateCandy_10_5", 10, 5, Wrapper.FOIL, Chocolate.DARK));
        presents.add(new ChocolateCandy("ChocolateCandy_5_0", 5, 0, Wrapper.FOIL, Chocolate.DARK));
        Present presentGift = new Gift(presents);
        ArrayList<Present> presents1 = new ArrayList<>();
        presents1.add(new ChocolateCandy("ChocolateCandy_20_10", 20, 10, Wrapper.FOIL, Chocolate.DARK));
        presents1.add(new ChocolateCandy("ChocolateCandy_10_5", 10, 5, Wrapper.FOIL, Chocolate.DARK));
        presents1.add(new ChocolateCandy("ChocolateCandy_5_0", 5, 0, Wrapper.FOIL, Chocolate.DARK));
        presents1.add(presentGift);
        gift = new Gift(presents1);
    }

    @AfterClass
    public static void afterClass() {
        gift = null;
    }

    @Test
    public void getWeight() {
        Assert.assertEquals(GIFT_WEIGHT, gift.getWeight());
    }

    @Test
    public void getSugarWeight() {
        Assert.assertEquals(GIFT_SUGAR_WEIGHT, gift.getSugarWeight());
    }

    @Test
    public void sortPresents() {
        gift.sortPresents(Present.SORT_PRESENT_BY_ASCENDING_SUGAR_WEIGTH);
        ArrayList<Present> presents = new ArrayList<>();
        presents.add(new ChocolateCandy("ChocolateCandy_20_10", 20, 10, Wrapper.FOIL, Chocolate.DARK));
        presents.add(new ChocolateCandy("ChocolateCandy_10_5", 10, 5, Wrapper.FOIL, Chocolate.DARK));
        presents.add(new ChocolateCandy("ChocolateCandy_5_0", 5, 0, Wrapper.FOIL, Chocolate.DARK));
        Present presentGift = new Gift(presents);
        ArrayList<Present> presents1 = new ArrayList<>();
        presents1.add(new ChocolateCandy("ChocolateCandy_20_10", 20, 10, Wrapper.FOIL, Chocolate.DARK));
        presents1.add(new ChocolateCandy("ChocolateCandy_10_5", 10, 5, Wrapper.FOIL, Chocolate.DARK));
        presents1.add(new ChocolateCandy("ChocolateCandy_5_0", 5, 0, Wrapper.FOIL, Chocolate.DARK));
        presents1.add(presentGift);
        Assert.assertNotEquals(presents1, gift.getPresents());
    }

    @Test
    public void findPastries() {
        ArrayList<Pastry> pastries = gift.findPastries(5,10);
        Assert.assertEquals(GIFT_FIND_PASTRIES, pastries.size());
    }

}