package ru.spbstu.icc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TheAddressBook {
    HashMap<String, Address> addressBook;

    public TheAddressBook(HashMap<String, Address> addressBook)
    {
        this.addressBook = addressBook;
    }

    public void set(String name, Address address)
    {
        addressBook.put(name, address);
    }

    public void remove(String name)
    {
        addressBook.remove(name);
    }

    public Address getAddress(String name)
    {
        return addressBook.get(name);
    }

    public ArrayList<String> getPeopleOnOneStreet(String streetName)
    {
        ArrayList<String> result = new ArrayList<>();
        addressBook.forEach((person, address) -> {
            if (address.street.equals(streetName)) result.add(person);
        });
        return result;
    }

    public ArrayList<String> getPeopleInOneHouse(String streetName, int houseNumber)
    {
        ArrayList<String> result = new ArrayList<>();
        addressBook.forEach((person, address) -> {
            if (address.street.equals(streetName) && address.houseNumber == houseNumber) result.add(person);
        });
        return result;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        addressBook.forEach((name, address) -> result.append("name: ").append(name).append("\n").append(address.toString()).append("\n"));
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressBook);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj instanceof TheAddressBook) {
            TheAddressBook other = (TheAddressBook) obj;
            return addressBook.equals(other.addressBook);
            }
        return false;
    }
}
