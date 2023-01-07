package fundamentalsSeptember2022_03Arrays_LAB;

import java.util.Arrays;
import java.util.Scanner;

public class P06_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] secondArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int sumFirstArray = 0;
        int indexDiffer = 0;
        boolean isIdentical = true;

        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] == secondArray[i]) {
                sumFirstArray += firstArray[i];
            } else{
                indexDiffer = i;
                isIdentical = false;
                break;
            }
        }
        if (isIdentical){
            System.out.printf("Arrays are identical. Sum: %d", sumFirstArray);
        } else{
            System.out.printf("Arrays are not identical. Found difference at %d index.", indexDiffer );
        }
    }
}
