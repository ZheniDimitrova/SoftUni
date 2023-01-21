package fundamentalsSeptember2022_08TextProcessing_Exercises;

import java.math.BigInteger;
import java.util.Scanner;

public class P05_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firsNum = new BigInteger(scanner.nextLine());
        BigInteger secondsNum = new BigInteger(scanner.nextLine());

        BigInteger result = firsNum.multiply(secondsNum);
        System.out.println(result);
    }
}
