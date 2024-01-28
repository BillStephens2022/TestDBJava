package com.billstephens;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\two4o\\Desktop\\JavaDevelopment\\TestDBJava\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
         try {
             Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             if (conn != null) {
                 System.out.println("Connection established successfully.");
             }
//             conn.setAutoCommit(false);
             assert conn != null;
             Statement statement = conn.createStatement();
             statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
             statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                     " (" + COLUMN_NAME + " text, " +
                     COLUMN_PHONE + " integer, " +
                     COLUMN_EMAIL + " text)");
             statement.execute("INSERT INTO " + TABLE_CONTACTS +
                     " (" + COLUMN_NAME + ", " +
                     COLUMN_PHONE + ", " +
                     COLUMN_EMAIL + " ) " +
                     "VALUES('Bill', 9876543210, 'bill@gmail.com')");
             statement.execute("INSERT INTO " + TABLE_CONTACTS +
                     " (" + COLUMN_NAME + ", " +
                     COLUMN_PHONE + ", " +
                     COLUMN_EMAIL + " ) " +
                     "VALUES('Joe', 5556667777, 'joe@yahoo.com')");
             statement.execute("INSERT INTO " + TABLE_CONTACTS +
                     " (" + COLUMN_NAME + ", " +
                     COLUMN_PHONE + ", " +
                     COLUMN_EMAIL + " ) " +
                     "VALUES('Jane', 4242424242, 'jane@hotmail.com')");
             statement.execute("INSERT INTO " + TABLE_CONTACTS +
                     " (" + COLUMN_NAME + ", " +
                     COLUMN_PHONE + ", " +
                     COLUMN_EMAIL + " ) " +
                     "VALUES('Fido', 3216549870, 'dog@aol.com')");
            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                    COLUMN_PHONE + "=6667778888" +
                    " WHERE " + COLUMN_NAME + "='Jane'");
            statement.execute("DELETE FROM " + TABLE_CONTACTS +
                    " WHERE " + COLUMN_NAME + "='Joe'");

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
             while(results.next()) {
                 System.out.println(results.getString(COLUMN_NAME) + " " +
                         results.getLong(COLUMN_PHONE) + " " +
                         results.getString(COLUMN_EMAIL));
             }
             results.close();
             statement.close();
             conn.close();

         } catch(SQLException e) {
             System.out.println("Something went wrong: " + e.getMessage());
             e.printStackTrace();
         }
    }
}
