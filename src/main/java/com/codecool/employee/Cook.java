package com.codecool.employee;

import lombok.Getter;

import java.time.LocalDate;

public class Cook extends Employee implements CookingEmployee {
    @Getter
    private boolean hasKnife;

    public Cook(String name, LocalDate birthDate, double salary) {
        super(name, birthDate, salary);
    }

    @Override
    public void cook() {
        System.out.println("Yes, I'm cooking Chef!");
    }

    @Override
    public void giveKnife() {
        this.hasKnife = true;
    }

    @Override
    public void startWork() {
        if (this.hasKnife) {
            cook();
        } else {
            System.out.println("I can not work without knife");
        }
    }
}
