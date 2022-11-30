package org.avisfy.tasks;

/**
 * Equal Sides Of An Array
 */
public class SidesOfArray {
    public static int findEvenIndex(int[] arr) {
        int sumLeft = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum - arr[0] == 0)
            return 0;

        for (int i = 1; i < arr.length ; i++) {
            sumLeft += arr[i - 1];
            if (sumLeft == sum - sumLeft - arr[i])
                return i;
        }

        return -1;
    }
}
