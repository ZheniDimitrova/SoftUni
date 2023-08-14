package advancedJanuary2023_01Ex_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> openBracketsStack = new ArrayDeque<>();

        String input = scanner.nextLine();

        boolean areBalanced = true;

        for (char bracket : input.toCharArray()){
             if (bracket == '(' || bracket == '[' || bracket == '{'){
                 openBracketsStack.push(bracket);

             } else if (bracket == ')' || bracket == ']' || bracket == '}' ){
                if (openBracketsStack.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char lastOpen = openBracketsStack.pop();
                if (lastOpen == '(' && bracket != ')' || lastOpen == '[' && bracket != ']' || lastOpen == '{' && bracket != '}'){
                    areBalanced = false;
                }

             }
        }
        if (areBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
