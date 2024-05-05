package com.codecool;

import com.codecool.employee.*;
import com.google.gson.Gson;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();

        LocalDate hireDate = LocalDate.now();

        Chef chef = new Chef("Magda", hireDate, 2345);

        Cook cook = new Cook("Jan", hireDate, 1350);
        Cook juniorCook = new Cook("Przemysław", hireDate, 1211);

        KitchenHelper firstHelper = new KitchenHelper("Michał", hireDate, 900);
        KitchenHelper secondHelper = new KitchenHelper("Damian", hireDate, 800);
        KitchenHelper thirdHelper = new KitchenHelper("Krzysztof", hireDate, 700);

        List<Employee> employeeList = List.of(chef, cook, juniorCook, firstHelper, secondHelper, thirdHelper);
        employeeList.forEach(kitchen::hireEmployee);

        kitchen.startShift();

        // to potem
        System.out.println(new Gson().toJson(new Student("Przemysław", 19)));
        System.out.println(new Gson().fromJson("{\"name\":\"Przemysław\",\"age\":19}", Student.class));
    }
}