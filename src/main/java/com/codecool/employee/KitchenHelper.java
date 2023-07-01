package com.codecool.employee;

import com.codecool.ingredients.Ingredient;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class KitchenHelper extends Employee {
    private final static Random random = new Random();
    private Map<Ingredient, Integer> ingredients = new HashMap<>();

    public KitchenHelper(String name, LocalDate birthDate, double salary) {
        super(name, birthDate, salary);

        for (Ingredient ingredient : Ingredient.values()) {
            ingredients.put(ingredient, 0);
        }
    }

    public void addIngredients() {
        int maxNumberOfIngredients = 3;

        for (Ingredient ingredient : Ingredient.values()) {
            int maxIngredientAmount = random.nextInt(maxNumberOfIngredients + 1);
            ingredients.merge(ingredient, maxIngredientAmount, Math::max);
        }
    }

    public Optional<Ingredient> giveIngredient(Ingredient ingredient) {
        if (hasIngredient(ingredient)) {
            deleteIngredient(ingredient);
            return Optional.of(ingredient);
        }

        return Optional.empty();
    }

    public boolean hasIngredient(Ingredient ingredient) {
        return ingredients.get(ingredient) > 0;
    }

    private void deleteIngredient(Ingredient ingredient) {
        int currentAmount = ingredients.get(ingredient);
        ingredients.replace(ingredient, currentAmount - 1);
    }
}
