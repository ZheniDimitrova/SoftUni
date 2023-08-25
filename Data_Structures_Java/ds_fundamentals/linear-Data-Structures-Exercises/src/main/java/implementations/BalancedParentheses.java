package implementations;

import interfaces.Solvable;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        char[] input = parentheses.toCharArray();

        for(int i = 0, j = input.length-1; i < j; i++, j--) {
            char first = input[i];
            char last = input[j];

            if ((first == '(' && last != ')') || (first == '{' && last != '}') || (first != '[' && last == ']')) {
                return false;
            }
        }
        return true;
    }
}


