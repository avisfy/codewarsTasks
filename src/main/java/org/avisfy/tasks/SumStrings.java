package org.avisfy.tasks;

public class SumStrings {
    public static String sumStrings(String a, String b) {
        char[] ac = a.replaceAll("^0+", "").toCharArray();
        char[] bc = b.replaceAll("^0+", "").toCharArray();

        int minLength, maxLength, delta;
        if (ac.length < bc.length) {
            minLength = ac.length;
            maxLength = bc.length;
            var temp = bc;
            bc = ac;
            ac = temp;
        } else {
            minLength = bc.length;
            maxLength = ac.length;
        }

        delta = maxLength - minLength;
        StringBuilder sum = new StringBuilder();
        boolean inMind = false;
        for (int i = maxLength - 1; i >= 0; i--) {
            int j = i - delta;
            int smallSum = 0;
            if (inMind) {
                smallSum = 1;
                inMind = false;
            }
            if (j >= 0) {
                smallSum += Character.getNumericValue(ac[i]) + Character.getNumericValue(bc[j]);
            } else {
                smallSum += Character.getNumericValue(ac[i]);
            }
            if (smallSum > 9) {
                smallSum = smallSum - 10;
                inMind = true;
            }
            sum.append(smallSum);
        }
        if (inMind)
            sum.append("1");
        return sum.reverse().toString();
    }

}
