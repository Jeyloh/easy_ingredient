package com.example.Easy_Ingredient;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is mainly used for storing recipes. Should be replaced by database entites later
 * Created by Jorgen on 3/6/2016.
 */
public class Recipe extends JavaDB{

    private HashMap<String, ArrayList<String>> recipe = new HashMap<>(); //String recipeName, String or Ingredient ingredient
    private ArrayList<String> ingredients;

    //replace ui fields
    private String userIngredient;
    private ArrayList<String> userIngredients;
    private String recipeName;

    /**
     * Used to construct a single recipe, based on the users input and add it to the database
     */
    public Recipe(){
        recipe = new HashMap<>();
        recipe.put(recipeName, userIngredients);

        listOfAllRecipes.add(recipe);
    }

    /**
     * Construct a recipe and add it to the database
     * @param recipeName
     * @param ingredients
     */
    public Recipe(String recipeName, ArrayList<String> ingredients){
        recipe.put(recipeName, ingredients);
        listOfAllRecipes.add(recipe);
    }

    /**
     * Used to check each recipe. For each recipe, check the ingredients list. If the userIngredients list
     * has all the ingredients in a recipe, return that recipe.
     *
     * @return all valid recipes the user can make //TODO implement this
     */
    public HashMap<String, ArrayList<String>> findMatchingRecipes(){

        HashMap<String, ArrayList<String>> matchingRecipes = new HashMap<>();

        System.out.println("TEST: Inside findMatchingRecipes()");
        for(Map.Entry<String, ArrayList<String>> recipeLine : recipe.entrySet()){ //For each set in the map

            String titles = recipeLine.getKey();
            ArrayList<String> ingredients = new ArrayList<>();//recipeLine.getValue();

            for(ArrayList<String> str : recipe.values()){
                System.out.println(str);
                for(String s : str){
                    ingredients.add(s);
                }
            }


            System.out.println("TEST: map key: " + titles + " map values " + ingredients);
            System.out.println("Going to check if database recipes contains your recipes");

            if(ingredients.containsAll(userIngredients)){
                matchingRecipes.put(titles, ingredients);
            }
        }

        return matchingRecipes;
    }

    public HashMap<String, ArrayList<String>> getRecipe() {
        return recipe;
    }

    public void setRecipe(HashMap<String, ArrayList<String>> recipe) {
        this.recipe = recipe;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public ArrayList<String> getUserIngredients() {
        return userIngredients;
    }

    public void setUserIngredients(ArrayList<String> userIngredients) {
        this.userIngredients = userIngredients;
    }

    public String getUserIngredient() {
        return userIngredient;
    }

    public void setUserIngredient(String userIngredient) {
        this.userIngredient = userIngredient;
    }

    public void makeTestData(){
        ArrayList<HashMap<String, ArrayList<String>>> test = new ArrayList<>();

        new Recipe("Homemade Burgers", new ArrayList<>(Arrays.asList("Buns", "Meat", "Lettuce", "Tomato", "Cheese")));
        new Recipe("Chicken Soup", new ArrayList<>(Arrays.asList("Chicken", "Yellow Onion", "Potato", "Spices", "Carrot")));
        new Recipe("Bread", new ArrayList<>(Arrays.asList("Flour", "Oil", "Salt", "Oat")));
        new Recipe("Boring Pizza", new ArrayList<>(Arrays.asList("Meat", "Cheese", "Flour", "Water", "Oil")));
        new Recipe("Toast", new ArrayList<>(Arrays.asList("Bread", "Cheese", "Ham", "Ketchup")));


    }
}
