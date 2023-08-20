package fundamentalsSeptember2022_02DataTypesAndVariables_Exercises;

import java.util.Scanner;

public class P08_BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfKegs = Integer.parseInt(scanner.nextLine());
        double maxVolume = Double.MIN_VALUE;
        String biggestKeg = "";

        for (int i = 1; i <= numberOfKegs ; i++) {
            String modelKeg = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radius, 2) * height;

            if (volume > maxVolume){
                maxVolume = volume;
                biggestKeg = modelKeg;
            }
        }
        System.out.println(biggestKeg);
    }
}
