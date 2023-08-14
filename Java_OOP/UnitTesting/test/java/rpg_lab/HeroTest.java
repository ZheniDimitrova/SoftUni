package rpg_lab;

import static org.junit.Assert.*;

public class HeroTest {

    public void testHeroGainsXPWhenTargetDies() {
        Dummy dummy = new Dummy(100, 10);
        Axe axe = new Axe(10, 10);
        Hero hero = new Hero("Hero");

        hero.attack(dummy);
    }

}