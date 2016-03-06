package com.example.Easy_Ingredient;

import java.util.ArrayList;

/**
 * Represent a single ingredient.
 *
 * Created by Jorgen on 3/6/2016.
 */
public class Ingredient {

    private String ingredientName;
    //private int ingredientAmount;

    /**
     * Construct an ingredient by using the parameter valye
     * @param ingredient
     */
    public Ingredient(String ingredient){
        this.ingredientName = ingredient;
    }


    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
