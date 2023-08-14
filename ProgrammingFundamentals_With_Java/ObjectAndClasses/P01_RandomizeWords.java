package fundamentalsSeptember2022_06ObjectsAndClasses;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordsList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Random randomWord = new Random();

        int sizeList = wordsList.size();

        for (int i = 0; i < sizeList; i++) {
            int rndIndex = randomWord.nextInt(wordsList.size());
            System.out.println(wordsList.get(rndIndex));
            wordsList.remove(rndIndex);
        }
    }
}
