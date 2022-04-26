package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class Main {

    public static void main(String[] args) {


        insert("Noam","2004");
        output();

    }

    //Insert data

    public static void insert(String UserName, String Password) {
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO accounts(UserName,Password) VALUES(?,?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, UserName);
            ps.setString(2, Password);
            ps.execute();
            System.out.println("Data has been inserted!");
        } catch(SQLException e) {
            System.out.println(e.toString() );
            e.printStackTrace();

        }
    }

    //Read Data From table

    public static void output(){
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        try {
            String sql = "select * from  accounts where password = '12345';";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)+", " + rs.getString(2));
            }
        } catch(SQLException e) {
            System.out.println(e.toString() );
            e.printStackTrace();

        }
    }

 /*
    public static void updateUsers(String UserName,String Password){
        //Only to update the first name of a certain row
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        try{
            String sql = "UPDATE uses set Password = ? WHERE User = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, UserName);
            ps.setString(2, Password);
            ps.execute();
        } catch(SQLException e){
            System.out.println(e.toString() );
            e.printStackTrace();
        }



}
*/


}



