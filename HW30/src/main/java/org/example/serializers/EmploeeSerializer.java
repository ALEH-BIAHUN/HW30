package org.example.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.Employee;

import java.lang.reflect.Type;

public class EmploeeSerializer implements JsonSerializer<Employee> {

    @Override
    public JsonElement serialize(Employee employee, Type type, JsonSerializationContext context) {
        JsonObject emploeeObject = new JsonObject();
        emploeeObject.addProperty("name", employee.getEmployeeName());
        emploeeObject.addProperty("position", employee.getPosition());
        emploeeObject.add("cases", context.serialize(employee.getCases()));
        return emploeeObject;
    }
}
