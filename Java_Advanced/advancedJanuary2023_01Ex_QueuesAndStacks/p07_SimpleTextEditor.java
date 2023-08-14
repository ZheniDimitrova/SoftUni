package advancedJanuary2023_01Ex_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder textEditor = new StringBuilder();
        ArrayDeque<String> textStack = new ArrayDeque<>();

        for (int i = 1; i <= n ; i++) {
            String[] commands = scanner.nextLine().split("\\s+");

            if (commands[0].equals("1")){
                textStack.push(textEditor.toString());
                String stringToAppend = commands[1];
                textEditor.append(stringToAppend);

            } else if (commands[0].equals("2")){
                textStack.push(textEditor.toString());
                int count = Integer.parseInt(commands[1]);
                textEditor.delete(textEditor.length() - count, (textEditor.length()));

            }else if (commands[0]. equals("3")){
                int index = Integer.parseInt(commands[1]);
                System.out.println(textEditor.charAt(index - 1));

            }else if (commands[0].equals("4")){
                if (!textStack.isEmpty()){
                    textEditor = new StringBuilder(textStack.pop());
                }

            }
        }
    }
}
