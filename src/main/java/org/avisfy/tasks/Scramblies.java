package org.avisfy.tasks;

import java.util.HashMap;
import java.util.Map;

public class Scramblies {
    public static boolean scramble(String str1, String str2) {
        Map<Character, Integer> dictionary = new HashMap<>();
        for(char c : str1.toCharArray()) {
            dictionary.put(c, dictionary.getOrDefault(c, 0) + 1);
        }

        boolean canRearrange = true;
        for(char c : str2.toCharArray()) {
            if (dictionary.getOrDefault(c, 0) == 0) {
                canRearrange = false;
                break;
            } else {
                dictionary.put(c, dictionary.get(c) - 1);
            }
        }
        return canRearrange;
    }
}
