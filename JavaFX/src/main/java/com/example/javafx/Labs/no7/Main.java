package com.example.javafx.Labs.no7;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    private static String DRIVER = "org.sqlite.JDBC";
    private static String DB_URL = "jdbc:sqlite:C:\\baza_miejscowosci.db";
    private static Connection conn;

    private TableView<ObservableList<String>> table = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Zadanie");

        Button refreshButton = new Button("Odśwież");
        refreshButton.setOnAction(e -> refresh());

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(refreshButton);
        borderPane.setCenter(table);

        Scene scene = new Scene(borderPane, 600, 400);
        primaryStage.setScene(scene);

        primaryStage.show();

        refresh(); // Odśwież dane przy starcie aplikacji
    }

    private void refresh() {
        table.getItems().clear(); // Wyczyść istniejące dane
        table.getColumns().clear(); // Wyczyść istniejące kolumny

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL);

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM miejscowosc");

            ResultSetMetaData metaData = result.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                final int j = i - 1;
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(metaData.getColumnName(i));
                column.setCellValueFactory(param ->
                        new ReadOnlyStringWrapper(param.getValue().get(j)));
                table.getColumns().add(column);
            }

            while (result.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(result.getString(i));
                }
                table.getItems().add(row);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}