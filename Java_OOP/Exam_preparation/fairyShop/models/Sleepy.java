package fairyShop.models;

public class Sleepy extends BaseHelper{

    private static final int START_ENERGY = 50;
    private static final int DECREASE_ENERGY = 15;

    public Sleepy(String name) {
        super(name, START_ENERGY);
    }

    @Override
    public void work() {
         setEnergy(Math.max(0, getEnergy() - DECREASE_ENERGY));
    }
}
