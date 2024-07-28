package org.avisfy.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrence) {
        Map<Integer, Integer> uniqueElCounts = new HashMap<>();
        List<Integer> resultElements = new ArrayList<>();
        for (int el : elements) {
            if (uniqueElCounts.getOrDefault(el, 0) < maxOccurrence) {
                resultElements.add(el);
                uniqueElCounts.put(el, uniqueElCounts.getOrDefault(el, 0) + 1);
            }
        }

        int[] result = new int[resultElements.size()];
        int i = 0;
        for (Integer re: resultElements) {
            result[i++] = re;
        }
        return result;
    }
}
