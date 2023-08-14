package Exam_Preparation;

import java.util.*;

public class p01_ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> foodStack = new ArrayDeque<>();
        ArrayDeque<Integer> staminaQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(foodStack::push);
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(staminaQueue::offer);

        List<String> conqueredPeaks = new ArrayList<>();
        List<String> peaksNames = new ArrayList<>();
        peaksNames.add("Vihren");
        peaksNames.add("Kutelo");
        peaksNames.add("Banski Suhodol");
        peaksNames.add("Polezhan");
        peaksNames.add("Kamenitza");

        Map <String, Integer> fivePirinPeaks = new LinkedHashMap<>(Map.of
                ("Vihren", 80,
                "Kutelo", 90,
                "Banski Suhodol", 100,
                "Polezhan", 60,
                "Kamenitza", 70));

        while(!foodStack.isEmpty() && !staminaQueue.isEmpty() && !fivePirinPeaks.isEmpty()) {

            String currentPeak = peaksNames.get(0);

            int food = foodStack.peek();
            int stamina = staminaQueue.peek();

            int sum = food + stamina;

            if (sum >= fivePirinPeaks.get(currentPeak)){
                conqueredPeaks.add(currentPeak);
                foodStack.pop();
                staminaQueue.poll();
                fivePirinPeaks.remove(currentPeak);
                peaksNames.remove(currentPeak);

            } else {

                foodStack.pop();
                staminaQueue.poll();
            }

        }

        if (fivePirinPeaks.isEmpty()){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");

        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeaks.isEmpty()){
            System.out.println("Conquered peaks:");

            for (String peak : conqueredPeaks){
                System.out.println(peak);
            }
        }

    }
}
