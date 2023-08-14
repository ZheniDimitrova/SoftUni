package robotService.entities.robot;

public class FemaleRobot extends BaseRobot{


    private static final int KILOGRAMS = 7;
    private static final int INCREASE_KG = 1;

    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, KILOGRAMS, price);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + INCREASE_KG);

    }
}
