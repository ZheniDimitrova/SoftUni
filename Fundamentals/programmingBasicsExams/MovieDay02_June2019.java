package programmingBasicsExams;

import java.util.Scanner;

public class MovieDay02_June2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int timeForMovie = Integer.parseInt(scanner.nextLine());
        int scenesNumber = Integer.parseInt(scanner.nextLine());
        double timeForOneScene = Double.parseDouble(scanner.nextLine());
        double preparation = timeForMovie * 0.15;

        double totalTime = scenesNumber * timeForOneScene + preparation;

        if ( timeForMovie >= totalTime){
            System.out.printf("You managed to finish the movie on time! You have %.0f minutes left!", timeForMovie - totalTime);
        } else{
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.", totalTime - timeForMovie);
        }
    }
}
