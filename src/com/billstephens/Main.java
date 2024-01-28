package com.billstephens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
         try {
             Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\two4o\\Desktop\\JavaDevelopment\\TestDBJava\\testjava.db");
             if (conn != null) {
                 System.out.println("Connection established successfully.");
             }
         } catch(SQLException e) {
             System.out.println("Something went wrong: " + e.getMessage());
         }
    }
}
