package ru.spbstu.icc;

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

    public String toString()
    {
        return ("street: " + this.getStreet() +
                "\nhouse: " + this.getHouseNumber() +
                "\napartment: " + this.getApartmentNumber());
    }

    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj instanceof Address) {
            Address other = (Address)obj;
            return street.equals(other.street) && houseNumber == other.houseNumber && apartmentNumber == other.apartmentNumber;
        }
        return  false;
    }
}
