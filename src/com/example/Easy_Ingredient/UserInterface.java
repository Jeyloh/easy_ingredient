package com.example.Easy_Ingredient;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Jorgen on 3/6/2016.
 */
public class UserInterface {

    private Recipe recipe = new Recipe();


    public UserInterface() {
        userInterface();
    }

public void userInterface() {

        System.out.println("Do you want to 'Create' or 'Retrieve' a recipe?");

        String userAnswer = scanInputString();

        //add recipe to the database
        if (userAnswer.equals("Create")) {

            //Method for creating and adding your recipe to the database
            userCreate();

        } else if (userAnswer.equals("Retrieve")) {
            System.out.println("You want to search for recipes containing your ingredients");
            sleep(1000);

            ArrayList<String> addedIngredients = new ArrayList<>();

            System.out.println("Add 1 ingredient at a time and press enter" +
                    "\nWhen you're complete, type in 'Done'");

            boolean check = true;
            while (check) {


                System.out.println("\nPlease insert your ingredient");
                String usersIngredient = scanInputString();


                if (usersIngredient.toLowerCase().equals("done")) {
                    check = false;
                } else {
                    System.out.println(usersIngredient);
                    addedIngredients.add(usersIngredient);
                    System.out.println("Your current ingredient(s) are");
                    for (String s : addedIngredients) {
                        System.out.println(" -- " + s);
                    }
                    recipe.setUserIngredients(addedIngredients);
                }
            }


            System.out.println("\nGreat! We added your ingredients to a list. Now we'll search our recipes and see " +
                    "if we find a match.");

            System.out.println("Searching for recipes containing");
            for (String s : recipe.getUserIngredients()) {
                System.out.println(s);
            }

            sleep(1000);

            System.out.println("\nHere are all the recipes you have ingredients to make! Happy cooking :-)");
            for (Map.Entry<String, ArrayList<String>> entry : recipe.findMatchingRecipes().entrySet()) {
                //findMatchingRecipes() returns a list a Map of all matching recipes
                System.out.println(" -- " + entry.getKey());
                for (String s : entry.getValue()) {
                    System.out.println("    --- " + s);
                }
            }

        } else {
            System.out.println("Sorry, please type in 'Create' or 'Retrieve' without apostrophes");
            //TODO take me to the start of the elif
        }


    }

    public void userCreate() {

        System.out.println("You want to create your own recipe." +
                "\nAdd a Recipe Name: ");

        recipe.setRecipeName(scanInputString());

        System.out.println("Your Recipes name is " + recipe.getRecipeName());

        boolean check = true;

        ArrayList<String> tempIngredientList = new ArrayList<>();


        while (check) {
            System.out.println("Add 1 ingredient at a time and press enter" +
                    "\nWhen you're complete, type in 'Done'");

            String item = scanInputString();

            if (item.toLowerCase().equals("done")) {
                check = false;
            } else {
                String currentItem = item;
                tempIngredientList.add(currentItem);
            }
        }

        recipe.setUserIngredients(tempIngredientList);

        sleep(1000);
        System.out.println(recipe.getRecipeName() + " contains these ingredients: ");
        for (String s : tempIngredientList) {
            System.out.println(" -- " + s);
        }
        System.out.println("Adding " + recipe.getRecipeName() + " to database.");
        System.out.println("Database contains " + recipe.getListOfAllRecipes().size() + " recipes");


        //Find a recipe in the database, corresponding to your ingredients
    }

    public String scanInputString() {
        Scanner scanProduct = new Scanner(System.in);
        String s = scanProduct.next();

        return s;
    }


    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
            for (int i = 0; i < ms / 1000; i++) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
