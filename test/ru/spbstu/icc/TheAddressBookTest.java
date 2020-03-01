package ru.spbstu.icc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import static org.junit.Assert.*;

public class TheAddressBookTest {
    TheAddressBook testBook = new TheAddressBook();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Before
    public void setUp() {
        testBook.set("Zadorotskas", new Address("Karla Marxa", 19, 16));
    }

    @Test
    public void set() {
        Address res = testBook.set("Zadorotskas", new Address("Harchenko", 16, 538));
        assertEquals(res, new Address("Karla Marxa", 19, 16));

        Address res1 = testBook.set("Feofilactov", new Address("Harchenko", 16, 538));
        System.out.println(testBook);
        assertNull(res1);
    }

    @Test
    public void remove() {
        Address res = testBook.remove("Zadorotskas");
        System.out.println(testBook);
        assertEquals(res, new Address("Karla Marxa", 19, 16));

        thrown.expect(IllegalArgumentException.class);
        testBook.remove("Ostapchyk");
        thrown = ExpectedException.none();
    }

    @Test
    public void getAddress() {
        testBook.set("Feofilactov", new Address("Harchenko", 16, 538));

        Address actual = new Address("Karla Marxa", 19, 16);
        Address expected = testBook.getAddress("Zadorotskas");

        System.out.println(expected);
        System.out.println(actual);
        assertEquals(expected, actual);

        Address actual1 = new Address("Harchenko", 16, 538);
        Address expected1 = testBook.getAddress("Feofilactov");
        assertEquals(expected1, actual1);

        thrown.expect(IllegalArgumentException.class);
        testBook.getAddress("Ostapchyk");
        thrown = ExpectedException.none();
    }

    @Test
    public void testToString() {
        testBook.set("Feofilactov", new Address("Harchenko", 16, 538));

        TheAddressBook newAddressBook = new TheAddressBook();
        assertEquals("", newAddressBook.toString());

        System.out.println(testBook);
        String actual = testBook.toString();
        String expected = "name: Feofilactov" +
                System.lineSeparator() + "street: Harchenko" +
                System.lineSeparator() + "house: 16" +
                System.lineSeparator() + "apartment: 538" +
                System.lineSeparator() + "name: Zadorotskas" +
                System.lineSeparator() + "street: Karla Marxa" +
                System.lineSeparator() + "house: 19" +
                System.lineSeparator() + "apartment: 16";
        System.out.println(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void getPeopleOnOneStreet() {
        testBook.set("Saveliev", new Address("Karla Marxa", 19, 19));
        testBook.set("Petrov", new Address("Karla Marxa", 20, 20));
        testBook.set("Ivanov", new Address("Lenina", 21, 32));

        List<String> actual = new ArrayList<>();
        List<String> expected1 = testBook.getPeopleOnOneStreet("Harchenko");
        assertEquals(expected1, actual);

        actual.add("Zadorotskas");
        actual.add("Saveliev");
        actual.add("Petrov");
        Collections.sort(actual);

        List<String> expected = testBook.getPeopleOnOneStreet("Karla Marxa");
        Collections.sort(expected);

        assertEquals(expected, actual);


    }

    @Test
    public void getPeopleInOneHouse() {
        testBook.set("Saveliev", new Address("Karla Marxa", 19, 19));
        testBook.set("Petrov", new Address("Karla Marxa", 20, 20));

        List<String> actual = new ArrayList<>();
        actual.add("Zadorotskas");
        actual.add("Saveliev");
        Collections.sort(actual);

        List<String> expected = testBook.getPeopleInOneHouse("Karla Marxa", 19);
        Collections.sort(expected);

        assertEquals(expected, actual);
    }
}