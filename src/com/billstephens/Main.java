package com.billstephens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
         try {
             Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\two4o\\Desktop\\JavaDevelopment\\TestDBJava\\testjava.db");
             if (conn != null) {
                 System.out.println("Connection established successfully.");
             }
             Statement statement = conn.createStatement();
             statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                     " (name TEXT, phone INTEGER, email TEXT)");
             statement.execute("INSERT INTO contacts (name, phone, email) " +
                     "VALUES('Bill', 9876543210, 'bill@gmail.com')");
             statement.close();
             conn.close();

         } catch(SQLException e) {
             System.out.println("Something went wrong: " + e.getMessage());
         }
    }
}
