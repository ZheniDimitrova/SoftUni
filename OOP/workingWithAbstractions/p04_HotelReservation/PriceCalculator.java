package workingWithAbstractions.p04_HotelReservation;

public class PriceCalculator {


    public static double calculateHolidayPrice (double pricePerDay, int numberOfDays, Season season, DiscountType discountType) {

        double totalPrice = pricePerDay * numberOfDays;
        totalPrice = totalPrice * season.getCoefficient();

        totalPrice = totalPrice - totalPrice * (discountType.getPercent()/100);

        return totalPrice;
    }
}
