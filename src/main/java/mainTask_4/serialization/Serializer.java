package mainTask_4.serialization;

import mainTask_4.entity.Present;

import java.util.ArrayList;

public interface Serializer {

    String serialize(ArrayList<Present> presents);

    ArrayList<Present> deserialize(String path);

}
