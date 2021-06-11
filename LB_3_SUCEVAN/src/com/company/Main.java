package com.company;

public class Main {

    public static void main(String[] args)
    {
        Meteorological_observations obj = new Meteorological_observations();
        obj.OrderByPressure();
        obj.MaxAtmospheric_pressure();

        Sklad obj1 = new Sklad();
        obj1.OrderByKg();
        System.out.println();
        obj1.SearchName("Костянтин");
    }
}
