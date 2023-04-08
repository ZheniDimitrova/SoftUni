package robotService.entities.robot;

public class MaleRobot extends BaseRobot{


    private static final int KILOGRAMS = 9;
    private static final int INCREASE_KG = 3;

    public MaleRobot(String name, String kind, double price) {
        super(name, kind, KILOGRAMS, price);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + INCREASE_KG);
    }
}
