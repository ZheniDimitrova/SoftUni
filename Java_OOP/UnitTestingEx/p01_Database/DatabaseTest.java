package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    public Database database;
    private static final Integer[] NUMBERS = {7, 45, 34, 12, 98, 23};


    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasCreateValidateObjects() {
        Integer[] elements = database.getElements();
        //Срявняваме дваата масива и като дължина, и като стойност на елементите
        Assert.assertArrayEquals("Arrays are not the same!", elements, NUMBERS);

        //втори начин за сряваняване на масивите и елементите в тях
        Assert.assertEquals("Count of elements is incorrect!", elements.length, NUMBERS.length);
        for (int i = 0; i < elements.length; i++) {
            Assert.assertEquals("Arrays are not the same!", elements[i], NUMBERS[i]);

        }

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)

    public  void testConstructorThrowWhenLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database();
    }

    @Test
    public void testAddShouldAddElement () throws OperationNotSupportedException {
        database.add(67);
        Integer[] elements = database.getElements();
        Assert.assertEquals("Invalid add operation", elements.length, NUMBERS.length + 1);
        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(67));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowNullParam() throws OperationNotSupportedException {
        database.add(null);

    }
    @Test
    public void testRemoveLastElement () throws OperationNotSupportedException {
        database.remove();
        Integer[] elements = database.getElements();
        Assert.assertEquals(elements.length, NUMBERS.length -1);
        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(98));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowEmptyDataBase () throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

}