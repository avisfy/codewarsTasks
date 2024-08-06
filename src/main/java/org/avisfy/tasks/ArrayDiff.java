package org.avisfy.tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayDiff {
    public static int[] arrayDiff(int[] a, int[] b) {
        Set<Integer> dict = new HashSet<Integer>(b.length);
        for (int bEl : b) {
            dict.add(bEl);
        }

        List<Integer> diff = new ArrayList<>();
        for (int aEl : a) {
            if (!dict.contains(aEl))
                diff.add(aEl);
        }

        return diff.stream().mapToInt(i -> i).toArray();
    }
}
