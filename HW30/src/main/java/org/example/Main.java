package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.deserializers.CaseDeserializer;
import org.example.deserializers.EmploeeDeserializer;
import org.example.serializers.CaseSerializers;
import org.example.serializers.EmploeeSerializer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Case caseOne = new Case("Годовой отчет",
                "Составить годовой отчет за 23 год",
                "отчет должен быть на 30 страниц");
        Case caseTwo = new Case("Магазин",
                "Зайти в магазин за продуктами",
                "Нужно взять молока и селедку");


        Employee hr = new Employee("Марина", 10000, "HR", List.of(caseOne));
        Employee manager = new Employee("Вася", 50000, "Manager", List.of(caseTwo));

        Company company = new Company(List.of(hr, manager));

        //todo сериализовывать тут в соответствии со структурой приложенной в файле занятия
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Case.class, new CaseSerializers())
                .registerTypeAdapter(Employee.class, new EmploeeSerializer())
                .registerTypeAdapter(Case.class, new CaseDeserializer())
                .registerTypeAdapter(Employee.class, new EmploeeDeserializer())
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(company);
        System.out.println(json);

        //todo десериализовывать тут обратно.
        Company company2 = gson.fromJson(json, Company.class);
        System.out.println(company2);
    }
}
