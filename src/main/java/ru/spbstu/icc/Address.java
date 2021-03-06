package ru.spbstu.icc;

import java.util.Objects;

public class Address {
    private final String street;
    private final int houseNumber;
    private final int apartmentNumber;

    public Address(String street, int houseNumber, int apartmentNumber)
    {
        if (houseNumber < 1 || apartmentNumber < 1) throw new IllegalArgumentException();
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public String getStreet()
    {
        return street;
    }

    public int getHouseNumber()
    {
        return houseNumber;
    }

    public int getApartmentNumber()
    {
        return apartmentNumber;
    }

    @Override
    public String toString() {
        return ("street: " + this.getStreet() +
                System.lineSeparator() + "house: " + this.getHouseNumber() +
                System.lineSeparator() + "apartment: " + this.getApartmentNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, houseNumber, apartmentNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Address) {
            Address other = (Address)obj;
            return street.equals(other.street) && houseNumber == other.houseNumber && apartmentNumber == other.apartmentNumber;
        }
        return  false;
    }
}
