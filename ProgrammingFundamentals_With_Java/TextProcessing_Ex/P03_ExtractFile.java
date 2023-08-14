package fundamentalsSeptember2022_08TextProcessing_Exercises;

import java.util.Scanner;

public class P03_ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pathArr = scanner.nextLine().split("\\\\");
        String fileName = "";
        String extension = "";

        for(String name : pathArr){
            String fullFileName = pathArr[pathArr.length -1];
            fileName = fullFileName.split("\\.")[0];
            extension = fullFileName.split("\\.")[1];
        }
        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s%n", extension);

    }
}
