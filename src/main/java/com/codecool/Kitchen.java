package com.codecool;

import com.codecool.employee.Chef;
import com.codecool.employee.Cook;
import com.codecool.employee.Employee;
import com.codecool.employee.KitchenHelper;
import com.codecool.ingredients.Ingredient;
import com.codecool.ingredients.IngredientStore;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Optional;

public class Kitchen implements IngredientStore {
    @Getter
    private Chef chef;
    private final ArrayList<Cook> cooks = new ArrayList<>();
    private final ArrayList<KitchenHelper> helpers = new ArrayList<>();

    public Optional<Ingredient> requestIngredient(Ingredient ingredient) {
        for (KitchenHelper helper : helpers) {
            if (helper.hasIngredient(ingredient)) {
                return helper.giveIngredient(ingredient);
            }
        }

        System.out.println("We are all out");
        return Optional.empty();
    }

    public void hireEmployee(Employee employee) {
        if (employee instanceof Cook cook) {
            cooks.add(cook);
            cook.giveKnife();

            return;
        }

        if (employee instanceof KitchenHelper helper) {
            helpers.add(helper);
            return;
        }

        if (employee instanceof Chef hiredChef) {
            hiredChef.giveKnife();
            hireChef(hiredChef);
        }
    }

    private void hireChef(Chef chef) {
        if (this.getChef() != null) {
            fireChef();
        }

        this.chef = chef;
        this.chef.setIngredientStore(this);
    }

    private void fireChef() {
        System.out.println("Gordon your time is gone");
        this.chef = null;
    }

    public void startShift() {
        helpers.forEach(KitchenHelper::addIngredients);

        if (this.getChef() != null) {
            cooks.forEach(Cook::startWork);
            chef.startWork();
        } else {
            throw new IllegalArgumentException("No chef on shift");
        }
    }
}
