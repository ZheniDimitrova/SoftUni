package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    //какво трябва да тестваме:
    //1.конструктора
    //1.1. празен списък с елементи
    //1.2. списък с елементи

    //2. has next + move

    //3. print
    //3.1.празен списък
    //3.2. списък с елементи

    private ListIterator listIterator;
    private static final String[] DATA = {"Desi", "Miroslav", "Boris", "Petar"};

    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator(DATA);
    }

    // 1.1
    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorNullParam() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    //1.2
   // @Test отпада за тестване, защото полетата са private

    //2.
    @Test
    public void testHasNextAndMove() {
        // current 0 -> 1
        Assert.assertTrue(listIterator.hasNext());  // current 1
        Assert.assertTrue(listIterator.move());

        //current 1 -> 2
        Assert.assertTrue(listIterator.hasNext()); // current 2
        Assert.assertTrue(listIterator.move());

        // current 2 -> 3
        Assert.assertTrue(listIterator.hasNext()); // current 3
        Assert.assertTrue(listIterator.move());

        //current 3
        Assert.assertFalse(listIterator.hasNext()); //false
        Assert.assertFalse(listIterator.move());

    }

    //3.1.
    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyList () throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    //3.2.
    @Test
    public void testPrintCorrectly () {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(listIterator.print(), DATA[index]);
            index++;
            listIterator.move(); // currentIndex += 1 (чрез този метод индексът се увеличава с 1)
        }
    }





}