package org.avisfy.tasks;

import java.util.Map;

public class PeteBaker {
    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        int cakesNumber = Integer.MAX_VALUE;
        for (String recipeIngr : recipe.keySet()) {
            if (available.getOrDefault(recipeIngr, 0) < recipe.get(recipeIngr)) {
                cakesNumber = 0;
                break;
            } else {
                int cakes = available.get(recipeIngr) / recipe.get(recipeIngr);
                if (cakes < cakesNumber)
                    cakesNumber = cakes;
            }
        }
        return cakesNumber;
    }
}
