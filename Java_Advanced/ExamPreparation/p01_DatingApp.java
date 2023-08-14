package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        ArrayDeque<Integer> maleStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(maleStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(femaleQueue::offer);

        int matches = 0;

        while(!maleStack.isEmpty() && !femaleQueue.isEmpty()) {

            int male = maleStack.peek();
            int female = femaleQueue.peek();

            if (male <= 0) {
                maleStack.pop();
                continue;

            } else if (male % 25 == 0) {
                maleStack.pop();
                if (!maleStack.isEmpty()){
                    maleStack.pop();
                    continue;
                } else {
                    break;
                }
            }

            if (female <= 0){
                femaleQueue.poll();
                continue;

            } else if (female % 25 == 0) {
                femaleQueue.pop();
                if (!femaleQueue.isEmpty()){
                    femaleQueue.pop();
                    continue;
                } else {
                    break;
                }
            }


            if (male == female){
                matches++;

                maleStack.pop();
                femaleQueue.poll();

            } else {
                femaleQueue.poll();
                maleStack.push(maleStack.pop() - 2);
            }


        }
            System.out.printf("Matches: %d%n", matches);
            System.out.print("Males left: ");
             if (maleStack.isEmpty()) {
                 System.out.println("none");
             } else  {
                 System.out.println(maleStack.toString().replaceAll("[\\[\\]]", ""));
             }

        System.out.print("Females left: ");
        if (femaleQueue.isEmpty()) {
            System.out.println("none");
        } else  {
            System.out.println(femaleQueue.toString().replaceAll("[\\[\\]]", ""));
        }

    }
}
