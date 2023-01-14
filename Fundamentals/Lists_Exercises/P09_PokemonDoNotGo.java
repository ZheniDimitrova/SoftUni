package fundamentalsSeptember2022_05Lists_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09_PokemonDoNotGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersPoke = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int sumRemovedIndexes = 0;

        while (numbersPoke.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index >= 0 && index <= numbersPoke.size() - 1) {
                int removedIndex = numbersPoke.get(index);
                sumRemovedIndexes += removedIndex;
                numbersPoke.remove(index);

                ModifyNumbersPoke(numbersPoke, removedIndex);

            } else if (index < 0) {

                int firstElem = numbersPoke.get(0);
                sumRemovedIndexes += firstElem;
                numbersPoke.remove(0);

                int lastElem = numbersPoke.get(numbersPoke.size() - 1);
                numbersPoke.add(0, lastElem);

                ModifyNumbersPoke(numbersPoke, firstElem);

            } else if (index > numbersPoke.size() - 1) {

                int lastElement = numbersPoke.get(numbersPoke.size() - 1);
                sumRemovedIndexes += lastElement;
                numbersPoke.remove(numbersPoke.size() - 1);
                int element1 = numbersPoke.get(0);
                numbersPoke.add(element1);

                ModifyNumbersPoke(numbersPoke, lastElement);
            }
        }
        System.out.println(sumRemovedIndexes);
    }

    private static void ModifyNumbersPoke(List<Integer> numbersPoke, int removedIndex) {
        for (int i = 0; i <= numbersPoke.size() - 1; i++) {
            int currentElem = numbersPoke.get(i);
            if (currentElem <= removedIndex) {
                currentElem += removedIndex;
            } else {
                currentElem -= removedIndex;
            }
            numbersPoke.set(i, currentElem);
        }
    }
}
