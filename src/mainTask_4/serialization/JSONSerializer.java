package mainTask_4.serialization;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import mainTask_4.Present;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JSONSerializer implements Serializer {

    private class JsonDeserializerWithInheritance<Shape> implements JsonDeserializer<Shape> {

        @Override
        public Shape deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            JsonPrimitive classNamePrimitive = (JsonPrimitive) jsonObject.get("type");
            String className = classNamePrimitive.getAsString();

            Class<?> clazz;
            try {
                clazz = Class.forName(className);
            } catch (ClassNotFoundException e) {
                return null;
            }
            return context.deserialize(jsonObject, clazz);
        }

    }

    @Override
    public String serialize(ArrayList<Present> presents) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        return gson.toJson(presents);
    }

    @Override
    public ArrayList<Present> deserialize(String json) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Present.class, new JsonDeserializerWithInheritance<Present>());
        Gson gson = builder.setPrettyPrinting().create();

        Type itemsArrType = new TypeToken<Present[]>() {}.getType();
        Present[] arrItemsDes = gson.fromJson(json, itemsArrType);

        ArrayList<Present> presents = new ArrayList<>();
        for (Present arrItemsDe : arrItemsDes) {
            if (arrItemsDe != null) {
                presents.add(arrItemsDe);
            }
        }
        return presents;
    }

}