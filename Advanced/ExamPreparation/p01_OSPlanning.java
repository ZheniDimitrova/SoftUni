package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tasksStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(threadsQueue::offer);

        int numToEnd = Integer.parseInt(scanner.nextLine());

        int taskItem = tasksStack.peek();
        int threadItem = threadsQueue.peek();


        while (taskItem != numToEnd) {

            if (threadItem >= taskItem) {
                tasksStack.pop();
            }
            threadsQueue.poll();

            taskItem = tasksStack.peek();
            threadItem = threadsQueue.peek();
        }

        System.out.printf("Thread with value %d killed task %d%n", threadItem, numToEnd);
        for (int num : threadsQueue){
            System.out.print(num + " ");
        }

    }
}
