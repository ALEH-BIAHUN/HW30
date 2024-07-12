package org.example.deserializers;

import com.google.gson.*;
import org.example.Case;
import org.example.Employee;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmploeeDeserializer implements JsonDeserializer<Employee> {
    @Override
    public Employee deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        Employee emp = new Employee();
        JsonObject empObject = jsonElement.getAsJsonObject();
        emp.setEmployeeName(empObject.get("name").getAsString());
        emp.setPosition(empObject.get("position").getAsString());

        List<Case> cases = new ArrayList<>();
        JsonArray caseArray = empObject.get("cases").getAsJsonArray();
        for (JsonElement jsonCase : caseArray) {
            cases.add(context.deserialize(jsonCase, Case.class));
        }
        emp.setCases(cases);
        return emp;
    }
}
