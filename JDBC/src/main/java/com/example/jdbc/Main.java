package com.example.jdbc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Main {

    private static String DRIVER = "org.sqlite.JDBC";
    public static String DB_URL = "jdbc:sqlite:src/baza_miejscowosci.db";

    public static void setDbUrl(String dbUrl) {
        DB_URL = dbUrl;
        System.out.println("Twoja sciezka to " + DB_URL);
    }

    private static Connection conn;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER); //sprawdzenie czy program ma dostęp do klasy pod wskazanym Stringiem.
        conn = DriverManager.getConnection(DB_URL);

        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM gmina");

        while (result.next()) {

            String kolumna1 = result.getString(1);// jako parametr podaje numery kolumn z których chce pobrac wartości. Wartości są konwertowane na string.
//            result.getInt(1) // jeśli chcę przekonwertować wartość z kolumny na int.
            String kolumna2 = result.getString(2);
            String kolumna3 = result.getString(3);
            System.out.println(kolumna1 + " " + kolumna2 + " " + kolumna3);
        }
    }


    //nie chcialo mi sie przenosic polaczenia z baza to sobie wzialem stad :)
    public static ObservableList<Miejscowosc> getRows() throws ClassNotFoundException, SQLException {
        ObservableList<Miejscowosc> rows = FXCollections.observableArrayList();
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(DB_URL);

        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM gmina");


        //kreci sie petla i dodaje do listy tej obserwujacej zwrocene rekordy :O
        while (result.next()) {

            rows.add(new Miejscowosc(result.getString(1), result.getString(2)));

        }
        return rows;
    }

}
