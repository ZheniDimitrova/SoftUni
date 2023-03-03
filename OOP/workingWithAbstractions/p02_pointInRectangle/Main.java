package workingWithAbstractions.p02_pointInRectangle;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();;

        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];

        Point pointBottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point pointTopRight = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(pointBottomLeft, pointTopRight);

        int countPoints = Integer.parseInt(scanner.nextLine());

        for (int point = 1; point <= countPoints; point++) {

            int [] checkPoints = Arrays.stream(scanner.nextLine()
                            .split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            int x = checkPoints[0];
            int y = checkPoints[1];

            Point searchedPoint = new Point(x, y);
            System.out.println(rectangle.contains(searchedPoint));

        }
    }
}
