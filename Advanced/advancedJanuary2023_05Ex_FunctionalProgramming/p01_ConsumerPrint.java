package advancedJanuary2023_05Ex_FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class p01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNames = scanner.nextLine().split("\\s+");

         Consumer<String> printName = System.out::println;
         for (String name : inputNames){
           printName.accept(name);
        }

      /*  Consumer<String[]> arrayNames = array -> {
            for (String name : array)
                System.out.println(name);
        };
        arrayNames.accept(inputNames);

       */
    }
}
