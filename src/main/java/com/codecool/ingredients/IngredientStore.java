package com.codecool.ingredients;

import java.util.Optional;

public interface IngredientStore {
    Optional<Ingredient> requestIngredient(Ingredient ingredient);
}
