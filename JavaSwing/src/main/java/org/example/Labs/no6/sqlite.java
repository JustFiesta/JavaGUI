package org.example.Labs.no6;

import java.sql.*;

public class sqlite {
    // it opens in file
    private static String url = "jdbc:sqlite:BAZA_PRODUKTOW.db";

    // no need for login and passwd
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");

        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM \"PRODUKT\"");
        ResultSetMetaData meta = result.getMetaData();

        for (int i = 0; i < meta.getColumnCount(); i++) {
            System.out.println(meta.getColumnName(i + 1) + " ");
        }
        System.out.println();

        while (result.next()) {
            for (int i = 0; i < meta.getColumnCount(); i++) {
                System.out.println(result.getString(i + 1) + " ");
                System.out.println();
            }
        }
    }
}
