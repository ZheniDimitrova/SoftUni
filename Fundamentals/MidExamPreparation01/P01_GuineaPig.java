package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.Scanner;

public class P01_GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double food = Double.parseDouble(scanner.nextLine());
        double hay = Double.parseDouble(scanner.nextLine());
        double cover = Double.parseDouble(scanner.nextLine());
        double pigWeight = Double.parseDouble(scanner.nextLine());

        double pigWeighInGrams = pigWeight * 1000;
        double foodInGrams = food * 1000;
        double hayInGrams = hay * 1000;
        double coverInGrams = cover * 1000;

        boolean isProductEnough = true;

            for (int day = 1; day <= 30; day++) {

                foodInGrams -= 300;


                if (day % 2 == 0) {
                    hayInGrams = hayInGrams - foodInGrams * 0.05;

                }
                if (day % 3 == 0) {
                    coverInGrams = coverInGrams - pigWeighInGrams / 3;

                }
                if (foodInGrams <= 0 || hayInGrams <= 0 || coverInGrams <= 0){
                    isProductEnough = false;
                    System.out.println("Merry must go to the pet store!");
                    break;
                }

            }
            if (isProductEnough) {
                System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", foodInGrams / 1000, hayInGrams / 1000, coverInGrams / 1000);
            }
        }

    }




