package com.company;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Meteorological_observations
{
    private String Date;
    private  Double Temperature;
    private int Atmospheric_pressure;

    public Meteorological_observations() { }

    public  Meteorological_observations(String date, Double temperature, int atmospheric_pressure)
    {
        Date = date;
        Temperature = temperature;
        Atmospheric_pressure = atmospheric_pressure;
    }

    public void OrderByPressure()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_lb","root","root");

            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery("select * from lb_3_13 ORDER BY Atmospheric_pressure ASC");
            while(rs.next())
                System.out.println("| " + rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3) + " | "+rs.getString(4) + " | ");
            con.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void MaxAtmospheric_pressure()
    {
        try
        {
            ArrayList<Meteorological_observations> list= new ArrayList<>();
            Class.forName("com.mysql.jdbc.Driver");

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_lb","root","root");

            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery("select * from lb_3_13 ORDER BY Atmospheric_pressure ASC");

           int max = 0, max2 = 0;


            while(rs.next())
            {
                list.add(new Meteorological_observations(rs.getString(2), rs.getDouble(3), rs.getInt(4)));
                if (rs.getInt(4) > max)
                {
                    max = rs.getInt(4);
                }
            }



            for (Meteorological_observations obj: list
                 ) {
                if (obj.Atmospheric_pressure != max)
                if (obj.Atmospheric_pressure > max2)
                {
                    max2 = obj.Atmospheric_pressure;
                }
            }




            System.out.println(max+" max2: " + max2);
            con.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
