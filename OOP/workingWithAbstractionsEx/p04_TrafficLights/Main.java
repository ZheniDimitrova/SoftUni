package workingWithAbstractionsEx.p04_TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] colors = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        List<Light> trafficLights = new ArrayList<>();

        for (String color : colors) {
            Light light = new Light(Color.valueOf(color));

            trafficLights.add(light);
        }

        for (int i = 0; i < n; i++) {

//            for (Light light : trafficLights) {
//                light.changeColor();
//                System.out.print(light.getColor() + " ");
//            }
            trafficLights.forEach(l -> {
                l.changeColor();
                System.out.print(l.getColor() + " ");
            });
            System.out.println();
        }
    }
}
