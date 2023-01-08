package fundamentalsSeptember2022_02DataTypesAndVariables_Exercises;

import java.util.Scanner;

public class P11_Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSnowballs = Integer.parseInt(scanner.nextLine());
        double maxSnowballValue = Double.MIN_VALUE;
        double maxSnowballSnow = Double.MIN_VALUE;
        double maxSnowballTime = Double.MIN_VALUE;
        double maxSnowballQuality = Double.MIN_VALUE;

        for (int i = 1; i <= numberOfSnowballs ; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
           double snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            long snowballValue = (long)Math.pow((snowballSnow / snowballTime), snowballQuality);
            if (snowballValue > maxSnowballValue){
                maxSnowballValue = snowballValue;
                maxSnowballSnow = snowballSnow;
                maxSnowballTime = snowballTime;
                maxSnowballQuality = snowballQuality;
            }

        }
        System.out.printf("%.0f : %.0f = %.0f (%.0f)", maxSnowballSnow, maxSnowballTime, maxSnowballValue, maxSnowballQuality);
    }
}
