package reflection_Exercise.barracksWars;

import reflection_Exercise.barracksWars.interfaces.Repository;
import reflection_Exercise.barracksWars.interfaces.Runnable;
import reflection_Exercise.barracksWars.interfaces.UnitFactory;
import reflection_Exercise.barracksWars.core.Engine;
import reflection_Exercise.barracksWars.core.factories.UnitFactoryImpl;
import reflection_Exercise.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
