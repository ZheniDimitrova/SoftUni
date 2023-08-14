package programmingBasicsExams;

import java.util.Scanner;

public class Renovation05_July2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());
        int area = height * width * 4;
        double partForPainting = Math.ceil(area - (area * 1.00 * percent / 100));
        boolean isTired = false;

        String input = scanner.nextLine();

        while (!input.equals("Tired!")) {
            int paintLitres = Integer.parseInt(input);
            partForPainting -= paintLitres;
            if (partForPainting == 0){
                System.out.println("All walls are painted! Great job, Pesho!");
                return;
            } else if (partForPainting < 0){
                System.out.printf("All walls are painted and you have %.0f l paint left!", Math.abs(partForPainting));
                return;
            }
            input = scanner.nextLine();
        }
        isTired = true;

        if (isTired){
            System.out.printf("%.0f quadratic m left.", partForPainting);
       }

    }
}
