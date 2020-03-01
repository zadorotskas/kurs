package ru.spbstu.icc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TheAddressBook {
    private final HashMap<String, Address> addressBook;

    public TheAddressBook()
    {
        this.addressBook = new HashMap<>();
    }

    public Address set(String name, Address address) {
        Address result = addressBook.get(name);
        addressBook.put(name, address);
        return result;
    }

    public Address remove(String name) {
        if (!addressBook.containsKey(name)) throw new IllegalArgumentException();
        Address result = addressBook.get(name);
        addressBook.remove(name);
        return result;
    }

    public Address getAddress(String name) {
        if (!addressBook.containsKey(name)) throw new IllegalArgumentException();
        return addressBook.get(name);
    }

    public List<String> getPeopleOnOneStreet(String streetName) {
        List<String> result = new ArrayList<>();
        addressBook.forEach((person, address) -> {
            if (address.getStreet().equals(streetName)) result.add(person);
        });
        return result;
    }

    public List<String> getPeopleInOneHouse(String streetName, int houseNumber) {
        List<String> result = new ArrayList<>();
        addressBook.forEach((person, address) -> {
            if (address.getStreet().equals(streetName) && address.getHouseNumber() == houseNumber) result.add(person);
        });
        return result;
    }

    @Override
    public String toString() {
        if (addressBook.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        addressBook.forEach((name, address) -> result.append("name: ").append(name).append(System.lineSeparator()).append(address.toString()).append(System.lineSeparator()));
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressBook);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof TheAddressBook) {
            TheAddressBook other = (TheAddressBook) obj;
            return addressBook.equals(other.addressBook);
            }
        return false;
    }
}
