package org.avisfy.tasks;

/**
 * Valid Parentheses
 */
public class ValidParentheses {
    public static boolean validParentheses(String parens) {
        int count = 0;
        for (char c : parens.toCharArray()) {
            if (count < 0)
                break;
            if (c == '(')
                count++;
            else if (c == ')')
                count--;
        }
        return (count == 0);
    }
}
