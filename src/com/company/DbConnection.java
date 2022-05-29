package com.company;

import java.sql.*;


public class DbConnection {
    public static Connection con = null;

    public static Connection connect() {

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:ACCOUNTS.db"); // connecting to database
            System.out.println("Connected!");
            Statement stmt = con.createStatement();
            String x = "create table if not exists ACCOUNTS (UserName text not null unique primary key, password text not null);";
            stmt.execute(x);
        } catch (ClassNotFoundException | SQLException e ) {
            // TODO Auto-generated catch block
            System.out.println(e+"");
        }

        return con;
    }

    public static void insert(String UserName, String Password) {
        Connection con = DbConnection.connect();
        PreparedStatement ps =null;
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

    public static void output(){
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        try {
            String sql = "select * from  accounts;";
            //String sql = "select * from  accounts where password = '12345';";
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


}



