package exercise_P05_VehicleCatalog;

public class Vehicle {
    private String typeOfVehicle;
    private String model;
    private String colour;
    private int horsePower;

    public Vehicle(String typeOfVehicle, String model, String colour, int horsePower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.colour = colour;
        this.horsePower = horsePower;
    }

    public String getTypeOfVehicle() {
        return this.typeOfVehicle;
    }

    public String getModel() {
        return this.model;
    }

    public String getColour() {
        return this.colour;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        if (typeOfVehicle.equals("car")){
            typeOfVehicle = "Car";
        } else if (typeOfVehicle.equals("truck")){
            typeOfVehicle = "Truck";
        }
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", this.typeOfVehicle, this.model, this.colour, this.horsePower);
    }
}
