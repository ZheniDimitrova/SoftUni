package fundamentalsSeptember2022_05Lists_Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07_AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> splitElementsByPipe = Arrays.stream(input.split("\\|")).collect(Collectors.toList());
        Collections.reverse(splitElementsByPipe);

        System.out.println(splitElementsByPipe.toString()
                .replace("[", "")
                .replace("]", "")
                .trim().replaceAll(",", "")
                .replaceAll("\\s+", " "));
    }
}
