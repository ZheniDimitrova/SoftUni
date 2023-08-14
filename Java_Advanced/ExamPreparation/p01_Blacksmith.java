package Exam_Preparation;

import java.util.*;

public class p01_Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(steelQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(carbonStack::push);
        Map<String, Integer> productsMap = new TreeMap<>();

        String gladius = "Gladius";
        String shamshir = "Shamshir";
        String katana = "Katana";
        String sabre = "Sabre";

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {

            int firstSteel = steelQueue.poll();
            int lastCarbon = carbonStack.peek();

            int sum = firstSteel + lastCarbon;

            if (sum == 70) {
                if (!productsMap.containsKey(gladius)){
                    productsMap.put(gladius, 1);
                } else {
                    productsMap.put(gladius, productsMap.get(gladius) + 1);
                }
            } else if (sum == 80) {
                if (!productsMap.containsKey(shamshir)){
                    productsMap.put(shamshir, 1);
                } else {
                    productsMap.put(shamshir, productsMap.get(shamshir) + 1);
                }
            } else if ( sum == 90){
                if (!productsMap.containsKey(katana)){
                    productsMap.put(katana, 1);
                } else {
                    productsMap.put(katana, productsMap.get(katana) + 1);
                }
            } else if ( sum == 110) {
                if (!productsMap.containsKey(sabre)){
                    productsMap.put(sabre, 1);
                } else {
                    productsMap.put(sabre, productsMap.get(sabre) + 1);
                }
            } else {
                int currentCarbon = carbonStack.pop() + 5;
                carbonStack.push(currentCarbon);
                continue;
            }

            carbonStack.pop();

        }
        int valueSum = 0;
        for (Map.Entry<String, Integer> entry : productsMap.entrySet()) {
            valueSum += entry.getValue();
        }

        if (valueSum == 0){
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            System.out.println("You have forged " +  valueSum+ " swords.");
        }

        if (steelQueue.isEmpty()){
            System.out.println("Steel left: none");
        } else {
            System.out.println("Steel left: ");
            System.out.println(steelQueue.toString().replaceAll("[\\[\\]]", ""));
        }

        if (carbonStack.isEmpty()){
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            System.out.println(carbonStack.toString().replaceAll("[\\[\\]]", ""));

        }

        for (Map.Entry<String, Integer> entry : productsMap.entrySet()) {
            if (entry.getValue() != 0){
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        }

    }
}
