package com.example.androidfragments;

public class IngredientsFragment extends CheckBoxesFragment{
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
