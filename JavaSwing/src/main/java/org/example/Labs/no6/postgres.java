package org.example.Labs.no6;

import java.sql.*;

public class postgres {

    //    0. get database from file and load it in pgadmin

    //    1. connection data
    private static String url = "jdbc:postgresql://localhost:3306/BAZA_PRODUKTOW";
    private static String user = "postgres";
    private static String passwd = "P@ssw0rd";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        2. select driver
        Class.forName("com.postgresql.Driver");

//        3. connect to database
        Connection connection = DriverManager.getConnection(url, user, passwd);

//        4. load statement (query tool)
        Statement statement = connection.createStatement();

//        5. fetch query
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
