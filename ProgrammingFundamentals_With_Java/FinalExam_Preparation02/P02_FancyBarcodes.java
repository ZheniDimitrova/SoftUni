package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int barcodeCount = Integer.parseInt(scanner.nextLine());
        String regex = "@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+";
        Pattern pattern = Pattern.compile(regex);


        for (int i = 1; i <= barcodeCount ; i++) {
            String barcode = scanner.nextLine();
            Matcher matcherBarcode = pattern.matcher(barcode);

            if (matcherBarcode.find()){
                String digitRegex = "[0-9]";
                Pattern pattern1 = Pattern.compile(digitRegex);
                Matcher matcherDigit = pattern1.matcher(barcode);
                String productGroup = "";

                while (matcherDigit.find()){
                    productGroup += matcherDigit.group();
                }
                if (productGroup.length() == 0){
                    System.out.println("Product group: 00");
                    continue;
                }

                System.out.println("Product group: " + productGroup);

            } else{
                System.out.println("Invalid barcode");
            }


        }

    }
}
