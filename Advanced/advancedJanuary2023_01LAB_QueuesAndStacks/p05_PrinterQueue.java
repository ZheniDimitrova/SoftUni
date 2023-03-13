package advancedJanuary2023_01LAB_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> files = new ArrayDeque<>();
        String fileName = "";

        while(!input.equals("print")){
            if (input.equals("cancel")){
                if (files.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    fileName = files.poll();
                    System.out.println("Canceled " + fileName);
                }
            }else{
                files.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String file : files){
            System.out.println(file);
        }
    }
}
