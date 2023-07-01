package com.codecool.employee;

import com.codecool.ingredients.Ingredient;
import com.codecool.ingredients.IngredientStore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

public class Chef extends Employee implements CookingEmployee {
    @Getter
    private boolean hasKnife;

    private final Random random = new Random();

    @Getter
    @Setter
    private IngredientStore ingredientStore;

    public Chef(String name, LocalDate birthDate, double salary) {
        super(name, birthDate, salary);
    }

    @Override
    public void cook() {
        boolean isRequestingIngredients = random.nextBoolean();

        if (isRequestingIngredients) {
            Ingredient ingredient = Ingredient.getRandomIngredient();
            System.out.println("I need " + ingredient.toString());
            Optional<Ingredient> requestIngredient = ingredientStore.requestIngredient(ingredient);
            // I've got meat
            // I've got nothing, you are all fired

            String answer = requestIngredient.map(Ingredient::toString).orElse("nothing, you are all fired");
            System.out.println("I've got " + answer);

            //requestIngredient.ifPresentOrElse((ing) -> System.out.println("I've got" + ing), () -> System.out.println("I've got nothing, you are all fired"));
            /*if (requestIngredient.isPresent()) {
                System.out.println("I've got" + requestIngredient.get());
            }
            else {
                System.out.println();
            }*/
        } else {
            System.out.println("Are you cooking guys?");
        }
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
