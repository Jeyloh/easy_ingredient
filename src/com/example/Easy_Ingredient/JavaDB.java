package com.example.Easy_Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Jorgen on 3/6/2016.
 */
public class JavaDB {



    protected ArrayList<HashMap<String, ArrayList<String>>> listOfAllRecipes = new ArrayList<>();

    public JavaDB(){
        System.out.println("You have " + listOfAllRecipes.size() + " recipes in your Database.");

    }


    public ArrayList<HashMap<String, ArrayList<String>>> getListOfAllRecipes() {
        return listOfAllRecipes;
    }

    public void setListOfAllRecipes(ArrayList<HashMap<String, ArrayList<String>>> listOfAllRecipes) {
        this.listOfAllRecipes = listOfAllRecipes;
    }



}
