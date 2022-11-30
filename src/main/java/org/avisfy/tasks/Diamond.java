package org.avisfy.tasks;

/**
 * Give me a Diamond
 */
public class Diamond {
    public static String print(int n) {
        if ((n<0) || ((n % 2) == 0))
            return null;
        int center = n/2 + 1;
        int left = center;
        int right = center;
        StringBuilder diamond = new StringBuilder();
        for (int i = 1; i <= n; i++ ) {
            for (int j = 1; j < left; j++)
            {
                diamond.append(" ");
            }
            for (int j = left; j <= right; j++)
            {
                diamond.append("*");
            }
            if (i >= center){
                left+=1;
                right-=1;
            } else {
                left-=1;
                right+=1;
            }
            diamond.append("\n");
        }
        return diamond.toString();
    }
}
