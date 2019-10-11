package mainTask_4.serialization;

import mainTask_4.entity.ChocolateCandy;
import mainTask_4.entity.Gift;
import mainTask_4.entity.Present;
import mainTask_4.enums.Chocolate;
import mainTask_4.enums.Wrapper;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JSONSerializerTest {

    private static Gift gift;
    private static String JSON;
    private static final JSONSerializer JSON_SERIALIZER = new JSONSerializer();

    @BeforeClass
    public static void beforeClass() {
        ArrayList<Present> presents = new ArrayList<>();
        presents.add(new ChocolateCandy("ChocolateCandy_20_10", 20, 10, Wrapper.FOIL, Chocolate.DARK));
        presents.add(new ChocolateCandy("ChocolateCandy_10_5", 10, 5, Wrapper.FOIL, Chocolate.DARK));
        presents.add(new ChocolateCandy("ChocolateCandy_5_0", 5, 0, Wrapper.FOIL, Chocolate.DARK));
        gift = new Gift(presents);
    }

    @AfterClass
    public static void afterClass() {
        gift = null;
    }

    @Test
    public void serialize() {
        ArrayList<Present> presents = new ArrayList<>();
        presents.add(gift);
        JSON = JSON_SERIALIZER.serialize(presents);
    }

    @Test
    public void deserialize() {
        ArrayList<Present> presents = JSON_SERIALIZER.deserialize(JSON);
        ArrayList<Present> presents1 = new ArrayList<>();
        presents1.add(gift);
        Assert.assertArrayEquals(presents1.toArray(), presents.toArray());
    }
}