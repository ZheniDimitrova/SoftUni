package workingWithAbstractions.p04_HotelReservation;

public enum Season {
    SPRING("Spring", 2),
    SUMMER("Summer", 4),
    AUTUMN("Autumn", 1),
    WINTER("Winter", 3);


    private String name;
    private  int coefficient;

    Season(String name, int coefficient) {
        this.name = name;
        this.coefficient = coefficient;
    }

    public String getName() {
        return name;
    }

    public int getCoefficient() {
        return coefficient;
    }
}
