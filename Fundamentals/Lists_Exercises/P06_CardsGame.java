package fundamentalsSeptember2022_05Lists_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (firstPlayerCards.size() != 0 && secondPlayerCards.size() != 0) {
            int firstCard = firstPlayerCards.get(0);
            int secondCard = secondPlayerCards.get(0);
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            if (firstCard > secondCard){
                firstPlayerCards.add(firstCard);
                firstPlayerCards.add(secondCard);
            } else if (secondCard > firstCard){
              secondPlayerCards.add(secondCard);
              secondPlayerCards.add(firstCard);
            }

        }
        int firstSum = 0;
        int secondSum = 0;
        if (firstPlayerCards.size() == 0){
            for (Integer card2 : secondPlayerCards) {
                secondSum += card2;
            }
            System.out.printf("Second player wins! Sum: %d", secondSum);
            } else if (secondPlayerCards.size() == 0){
                for (Integer card1 : firstPlayerCards) {
                    firstSum += card1;
                }
            System.out.printf("First player wins! Sum: %d", firstSum);
            }
        }
    }

