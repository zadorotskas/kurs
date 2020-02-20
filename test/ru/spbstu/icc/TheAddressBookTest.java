package ru.spbstu.icc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
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
                "\napartment: 16";
        assertEquals(expected, actual);
    }

    @Test
    public void getPeopleOnOneStreet() {
        TheAddressBook addressBook = new TheAddressBook(new HashMap<>());
        addressBook.set("Zadorotskas", new Address("Karla Marxa", 19, 16));
        addressBook.set("Saveliev", new Address("Karla Marxa", 19, 19));
        addressBook.set("Petrov", new Address("Karla Marxa", 20, 20));
        addressBook.set("Ivanov", new Address("Lenina", 21, 32));

        ArrayList<String> actual = new ArrayList<>();
        actual.add("Zadorotskas");
        actual.add("Saveliev");
        actual.add("Petrov");
        Collections.sort(actual);

        ArrayList<String> expected = addressBook.getPeopleOnOneStreet("Karla Marxa");
        Collections.sort(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void getPeopleInOneHouse() {
        TheAddressBook addressBook = new TheAddressBook(new HashMap<>());
        addressBook.set("Zadorotskas", new Address("Karla Marxa", 19, 16));
        addressBook.set("Saveliev", new Address("Karla Marxa", 19, 19));
        addressBook.set("Petrov", new Address("Karla Marxa", 20, 20));

        ArrayList<String> actual = new ArrayList<>();
        actual.add("Zadorotskas");
        actual.add("Saveliev");
        Collections.sort(actual);

        ArrayList<String> expected = addressBook.getPeopleInOneHouse("Karla Marxa", 19);
        Collections.sort(expected);

        assertEquals(expected, actual);
    }
}