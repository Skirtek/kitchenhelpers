package com.codecool.ingredients;

import java.util.Random;

public enum Ingredient {
    MEAT,
    POTATES,
    CARROT;

    private final static Random random = new Random();

    public static Ingredient getRandomIngredient(){
        var values = values();
        int lengthOfValues = values.length;

        return values[random.nextInt(lengthOfValues)];
    }
}
