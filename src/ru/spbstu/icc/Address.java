package ru.spbstu.icc;

import java.util.Objects;

public class Address {
    String street;
    int houseNumber;
    int apartmentNumber;

    public Address(String street, int houseNumber, int apartmentNumber)
    {
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
                "\nhouse: " + this.getHouseNumber() +
                "\napartment: " + this.getApartmentNumber());
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
