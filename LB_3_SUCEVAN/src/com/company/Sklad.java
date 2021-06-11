package com.company;

import java.sql.*;

public class Sklad
{
    private int ID;
    private String Name;
    private int Kg;
    private int Price;
    private int Count;

    public Sklad() {}

    public  Sklad(String name, int kg, int price, int count)
    {
        Name= name;
        Kg = kg;
        Price = price;
        Count = count;
    }

    public void OrderByKg()
    {

            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_lb","root","root");

                Statement stmt = con.createStatement();
                ResultSet rs =stmt.executeQuery("select * from lb_3_1_13 ORDER BY Kg DESC");
                while(rs.next())
                    System.out.println("| " + rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3) + " | "+rs.getString(4) + " | " +rs.getString(5) + " | ");
                con.close();

            }
            catch(Exception e)
            {
                System.out.println(e);
            }

    }

    public void SearchName(String name)
    {
        try
        {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_lb","root","root");

            Statement stmt = con.createStatement();
            String sql = "Select * from lb_3_1_13 where Name = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);

//            Statement stmt = con.createStatement();
            ResultSet rs = pst.executeQuery();
            while(rs.next())
                System.out.println("| " + rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3) + " | "+rs.getString(4) + " | " +rs.getString(5) + " | ");
            con.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
