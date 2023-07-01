package com.codecool.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@ToString
public abstract class Employee {
    private String name;
    private LocalDate birthDate;
    private double salary;

    public void printTax() {
        double tax = salary * 0.99;
        System.out.println("My tax is: " + tax);
    }
}
