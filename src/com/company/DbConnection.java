package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


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


}



