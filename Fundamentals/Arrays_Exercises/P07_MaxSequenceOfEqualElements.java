package fundamentalsSeptember2022_03Arrays_Exercises;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Arrays;
import java.util.Scanner;

public class P07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int countEqualNumbers = 1;
        int maxEqualNumbers = 0;
        int startIndex = 0;
        int endIndex = 0;

        for (int index = 0; index <= numbersArr.length - 2; index++) {
            int currentNum = numbersArr[index];
            int nextNum = numbersArr[index + 1];

            if (currentNum == nextNum) {
                countEqualNumbers++;
            } else {
                if (countEqualNumbers > maxEqualNumbers) {
                    maxEqualNumbers = countEqualNumbers;
                    endIndex = index;
                    startIndex = (endIndex + 1) - countEqualNumbers;
                }
                countEqualNumbers = 1;
            }
        }
        if (countEqualNumbers > maxEqualNumbers) {
            maxEqualNumbers = countEqualNumbers;
            endIndex = numbersArr.length-1;
            startIndex = (endIndex + 1) - countEqualNumbers;
        }
        for (int i = startIndex; i <= endIndex ; i++) {
            int thisNumber = numbersArr[i];
            System.out.print(thisNumber +" ");
        };

    }
}

