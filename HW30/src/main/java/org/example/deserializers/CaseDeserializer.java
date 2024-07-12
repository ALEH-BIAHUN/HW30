package org.example.deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.example.Case;

import java.lang.reflect.Type;

public class CaseDeserializer implements JsonDeserializer<Case> {
    @Override
    public Case deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        Case c = new Case();
        String data = jsonElement.getAsString();
        String title = data.substring(0, data.indexOf(":"));
        String description = data.substring(data.indexOf(":") + 1);
        c.setDescription(description);
        c.setCaseTitle(title);
        return c;
    }
}
