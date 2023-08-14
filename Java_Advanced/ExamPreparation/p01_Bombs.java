package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_Bombs {

    private  static final int DATURABOMBS = 40;
    private  static final  int CHERRYBOMBS = 60;
    private  static final int SMOKEDECOYBOMBS = 120;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(bombEffectsQueue::offer);
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(bombCasingsStack::push);

        int sum = 0;
        int daturaCount = 0, cherryCount = 0, smokeCount = 0;

        while((!bombEffectsQueue.isEmpty() && !bombCasingsStack.isEmpty()) && !(daturaCount >= 3 && cherryCount >= 3 && smokeCount >= 3)){

           int effect =  bombEffectsQueue.peek();
           int casing = bombCasingsStack.peek();

           sum = effect + casing;

           switch (sum){

               case DATURABOMBS:
                   daturaCount++;

                   bombEffectsQueue.poll();
                   bombCasingsStack.pop();

                   break;

               case CHERRYBOMBS:
                   cherryCount++;
                   bombEffectsQueue.poll();
                   bombCasingsStack.pop();

                   break;

               case SMOKEDECOYBOMBS:
                   smokeCount++;
                   bombEffectsQueue.poll();
                   bombCasingsStack.pop();

                   break;

               default:  bombCasingsStack.push(bombCasingsStack.pop() - 5);

           }


        }

        if (daturaCount >= 3 && cherryCount >= 3 && smokeCount >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        System.out.print("Bomb Effects: ");
        if (bombEffectsQueue.isEmpty()){
            System.out.println("empty");

        } else {
            System.out.println(bombEffectsQueue.toString().replaceAll("[\\[\\]]", ""));
        }

        System.out.print("Bomb Casings: ");
        if (bombCasingsStack.isEmpty()){
            System.out.println("empty");

        } else {
            System.out.println(bombCasingsStack.toString().replaceAll("[\\[\\]]", ""));
        }


        System.out.printf("Cherry Bombs: %d%nDatura Bombs: %d%nSmoke Decoy Bombs: %d", cherryCount, daturaCount, smokeCount);

    }
}
