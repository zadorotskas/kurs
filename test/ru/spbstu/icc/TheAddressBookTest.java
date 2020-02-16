package ru.spbstu.icc;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TheAddressBookTest {



    @Test
    public void set() {

        HashMap<String, Address> testMap = new HashMap<>();
        testMap.put("Zadorotskas", new Address("Karla Marxa", 19, 16));
        TheAddressBook expected = new TheAddressBook(testMap);

        TheAddressBook actual = new TheAddressBook(new HashMap<>());
        actual.set("Zadorotskas", new Address("Karla Marxa", 19, 16));

        System.out.println(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        HashMap<String, Address> testMap1 = new HashMap<>();
        testMap1.put("Zadorotskas", new Address("Karla Marxa", 19, 16));
        TheAddressBook expected = new TheAddressBook(testMap1);

        HashMap<String, Address> testMap2 = new HashMap<>();
        testMap2.put("Zadorotskas", new Address("Karla Marxa", 19, 16));
        testMap2.put("Feofilactov", new Address("Harchenko", 16, 538));
        TheAddressBook actual = new TheAddressBook(testMap2);

        actual.remove("Feofilactov");
        assertEquals(expected, actual);
    }

    @Test
    public void getAddress() {
        HashMap<String, Address> testMap = new HashMap<>();
        testMap.put("Zadorotskas", new Address("Karla Marxa", 19, 16));
        testMap.put("Feofilactov", new Address("Harchenko", 16, 538));
        TheAddressBook testBook = new TheAddressBook(testMap);

        Address actual = new Address("Karla Marxa", 19, 16);
        Address expected = testBook.getAddress("Zadorotskas");

        System.out.println(expected);
        System.out.println(actual);
        assertEquals(expected, actual);

        Address actual1 = new Address("Harchenko", 16, 538);
        Address expected1 = testBook.getAddress("Feofilactov");
        assertEquals(expected1, actual1);
    }

    @Test
    public void testToString() {

        HashMap<String, Address> testMap = new HashMap<>();
        testMap.put("Zadorotskas", new Address("Karla Marxa", 19, 16));
        testMap.put("Feofilactov", new Address("Harchenko", 16, 538));
        TheAddressBook testBook = new TheAddressBook(testMap);


        System.out.println(testBook);
        String actual = testBook.toString();
        String expected = "name: Feofilactov" +
                "\nstreet: Harchenko" +
                "\nhouse: 16" +
                "\napartment: 538" +
                "\nname: Zadorotskas" +
                "\nstreet: Karla Marxa" +
                "\nhouse: 19" +
                "\napartment: 16" +
                "\n";
        assertEquals(expected, actual);
    }
}