package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private static final Person[] PEOPLE = {new Person(1, "Nikolai"), new Person(2, "Viki"), new Person(3, "Geri")};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }
    @Test
    public void testConstructorHasCreateValidObject () {
        Person[] elements = database.getElements();
        Assert.assertArrayEquals("Arrays are not the same", elements, PEOPLE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowMoreThan16Elements () throws OperationNotSupportedException {
        Person[] elements = new Person[17];
        new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
        public void testConstructorThrowLessThan1Element () throws OperationNotSupportedException {
            Person[] people = new Person[0];
            new Database(people);
        }

        @Test
        public void testAddElement () throws OperationNotSupportedException {
        database.add(new Person(4, "Zheni"));

        Person[] people = database.getElements();
        Assert.assertEquals(people.length, PEOPLE.length + 1);
        Assert.assertEquals(Integer.valueOf(people[people.length - 1].getId()), Integer.valueOf(4));
        Assert.assertEquals(people[people.length - 1].getUsername(), "Zheni");
        }

        @Test (expected = OperationNotSupportedException.class)
        public void testAddShouldThrowNullParameter () throws OperationNotSupportedException {
        database.add(null);
        }

        @Test
        public void testRemoveLastElement () throws OperationNotSupportedException {
        database.remove();
        Person[] people = database.getElements();
        Assert.assertEquals(people.length, PEOPLE.length - 1);
        Assert.assertEquals(Integer.valueOf(people[people.length - 1]. getId()), Integer.valueOf(2));
        Assert.assertEquals(people[people.length - 1].getUsername(), "Viki");
        }

        @Test (expected = OperationNotSupportedException.class)
        public void testRemoveThrowEmptyDatabase () throws OperationNotSupportedException {
            database = new Database(); //празна база данни
            database.remove();
        }

        @Test (expected = OperationNotSupportedException.class)
        public void testFindByUsernameThrowNullParam () throws OperationNotSupportedException {
        database.findByUsername(null);
        }

        @Test (expected = OperationNotSupportedException.class)
        public void testFindByUsernameThrowEmptyDatabase () throws OperationNotSupportedException {
        database = new Database();
        database.findByUsername("Geri");
        }

        @Test
        public void testFindByUsername () throws OperationNotSupportedException {
        Person person = database.findByUsername("Viki");
        Assert.assertEquals(2,person.getId());
        Assert.assertEquals("Viki", person.getUsername());
        }

        @Test (expected = OperationNotSupportedException.class)//ако имаме двама човека с това име
        public void testFindByUsernameMoreThanOnePerson() throws OperationNotSupportedException {
        database.add(new Person(4, "Geri"));
        database.findByUsername("Geri");
        }

        @Test(expected = OperationNotSupportedException.class)
        public void testFindByUsernameInvalidName() throws OperationNotSupportedException {
        database.findByUsername("Petar");
        }

        @Test
        public void testGetById () throws OperationNotSupportedException {
        Person person = database.findById(1);
        Assert.assertEquals(person.getId(), 1);
        Assert.assertEquals(person.getUsername(), "Nikolai");
        }

        @Test(expected = OperationNotSupportedException.class)
        public void testFindByIdMoreThanOneId () throws OperationNotSupportedException {
        database.add(new Person(2, "Viktoria"));
        database.findById(2);
        }

        @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdEmptyData() throws OperationNotSupportedException {
        database = new Database();
        database.findById(2);
        }





    }



