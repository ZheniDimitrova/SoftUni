package fundamentalsSeptember2022_09RegularExpressions_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalPrice = 0;
        double finalIncome = 0;

        String regex = "%(?<customer>[A-Z][a-z]*)%[^|$%.]*?<(?<product>\\w+)>[^|$%.]*?\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.?[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String customerName = matcher.group("customer");
                String productName = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("count"));
                double pricePerOne = Double.parseDouble(matcher.group("price"));
                totalPrice = quantity * pricePerOne;
                finalIncome += totalPrice;

                System.out.printf("%s: %s - %.2f%n", customerName, productName, totalPrice);
            }
            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", finalIncome);
    }
}
