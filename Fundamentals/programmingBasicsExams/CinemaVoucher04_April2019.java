package programmingBasicsExams;

import java.util.Scanner;

public class CinemaVoucher04_April2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int voucher = Integer.parseInt(scanner.nextLine());
        int filmTickets = 0;
        int products = 0;
        String productName = scanner.nextLine();
        while (!productName.equals("End")){

            if (productName.length() > 8){
                int ticketPrice = productName.charAt(0) + productName.charAt(1);
                voucher -= ticketPrice;
                if(voucher < 0) {
                    break;
                }
                filmTickets ++;
                }

            if (productName.length()<= 8){
                int productPrice = productName.charAt(0);
                voucher -= productPrice;
                if(voucher < 0) {
                    break;
                }
                products++;
            }

            productName = scanner.nextLine();
        }
        System.out.println(filmTickets);
        System.out.println(products);
    }
}
