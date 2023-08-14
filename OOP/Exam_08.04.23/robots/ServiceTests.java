package robots;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTests {


    @Test
    public void testConstructor () {
         Service service = new Service("Java", 20);
         Robot robot = new Robot("Jeri");
        Assert.assertEquals("Java", service.getName());
        Assert.assertEquals(20, service.getCapacity());
        Assert.assertEquals(0, service.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testIfNameIsNull () {
        Service service = new Service(null, 20);
    }

    @Test(expected = NullPointerException.class)
    public void testIfNameIsEmpty () {
        Service service = new Service("", 20);
    }

    @Test(expected = NullPointerException.class)
    public void testIfNameIsWhiteSpace () {
        Service service = new Service(null, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacityIsLessThanZero () {
        Service service = new Service("java", -2);
    }

    @Test
    public void testAddRobotValid () {
        Service service = new Service("Java", 20);
        Robot robot1 = new Robot("Jeri");
        Robot robot2 = new Robot("John");
        service.add(robot1);
        service.add(robot2);
        Assert.assertEquals(2, service.getCount());
        Assert.assertEquals("Jeri", robot1.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSizeEqualsToCapacity () {
        Service service = new Service("Java", 1);
        Robot robot1 = new Robot("Jeri");
        Robot robot2 = new Robot("John");
        service.add(robot1);
        service.add(robot2);
    }
    @Test
    public void testRemoveRobotValid () {
        Service service = new Service("Java", 10);
        Robot robot1 = new Robot("Jeri");
        Robot robot2 = new Robot("John");
        service.add(robot1);
        service.add(robot2);
        Assert.assertEquals(2, service.getCount());
        service.remove(robot2.getName());
        Assert.assertEquals(1, service.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRobotIfNull () {
        Service service = new Service("Java", 10);
        Robot robot1 = new Robot("Jeri");
        Robot robot2 = new Robot("John");
        service.add(robot1);
        service.add(robot2);
        Assert.assertEquals(2, service.getCount());
        service.remove("Alex");
    }
    @Test
    public void testForSaleValid () {
        Service service = new Service("Java", 10);
        Robot robot1 = new Robot("Jeri");
        Robot robot2 = new Robot("John");
        service.add(robot1);
        service.add(robot2);
        service.forSale(robot1.getName());
        Assert.assertEquals("Jeri", robot1.getName());
        Assert.assertFalse(robot1.isReadyForSale());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testForSaleIsNull () {
        Service service = new Service("Java", 10);
        Robot robot1 = new Robot("Jeri");
        Robot robot2 = new Robot("John");
        service.add(robot1);
        service.add(robot2);
        service.forSale("Alex");
    }


}
