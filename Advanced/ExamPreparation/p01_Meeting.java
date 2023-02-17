package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        ArrayDeque<Integer> maleStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(maleStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(femaleQueue::offer);

        int relationships = 0;

        while(!femaleQueue.isEmpty() && !maleStack.isEmpty()) {

            int female = femaleQueue.peek();
            int male = maleStack.peek();

            if (female <= 0){
                femaleQueue.poll();
                continue;

            } else if (female % 25 == 0) {
                if (!femaleQueue.isEmpty()) {
                    femaleQueue.poll();
                    continue;
                } else {
                    break;
                }
            }

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

            if (female == male) {
                relationships++;

                femaleQueue.poll();
                maleStack . pop();


            } else {
                femaleQueue.poll();
                maleStack.push(maleStack.pop() - 2);
            }

        }
        System.out.printf("Matches: %d%n", relationships);
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
