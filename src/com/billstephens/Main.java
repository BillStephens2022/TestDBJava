package com.billstephens;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
         try {
             Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\two4o\\Desktop\\JavaDevelopment\\TestDBJava\\testjava.db");
             if (conn != null) {
                 System.out.println("Connection established successfully.");
             }
//             conn.setAutoCommit(false);
             assert conn != null;
             Statement statement = conn.createStatement();
             statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                     " (name TEXT, phone INTEGER, email TEXT)");
//             statement.execute("INSERT INTO contacts (name, phone, email) " +
//                     "VALUES('Joe', 3332221111, 'joe@yahoo.com')");
//             statement.execute("INSERT INTO contacts (name, phone, email) " +
//                     "VALUES('Jane', 4445556666, 'jane@hotmail.com')");
//             statement.execute("INSERT INTO contacts (name, phone, email) " +
//                     "VALUES('Fido', 8889876543, 'dog@aol.com')");
//             statement.execute("UPDATE contacts SET phone=4242424242 WHERE name='Jane'");
//             statement.execute("DELETE FROM contacts WHERE name = 'Joe'");
             statement.execute("SELECT * FROM contacts");
             ResultSet results = statement.getResultSet();
             while(results.next()) {
                 System.out.println(results.getString("name") + " " +
                         results.getLong("phone") + " " +
                         results.getString("email"));
             }
             results.close();
             statement.close();
             conn.close();

         } catch(SQLException e) {
             System.out.println("Something went wrong: " + e.getMessage());
         }
    }
}
