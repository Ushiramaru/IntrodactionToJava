package mainTask_4.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mainTask_4.Present;

import java.util.ArrayList;

public class JSONSerializer implements Serializer {

    @Override
    public String serialize(ArrayList<Present> presents) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        return gson.toJson(presents);
    }

    @Override
    public ArrayList<Present> deserialize(String path) {
        return null;
    }

}