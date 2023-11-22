package com.example.jdbc;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.sql.SQLException;


public class TableVievTest extends Application {
    //pole tekstowe
    Label textlabel = new Label("Path:");
    TextField textField = new TextField();

    public static final TableView<Miejscowosc> table = new TableView<>();

    private static void showFiles() {

    }

    //tutaj se smiga taka petla z maina i ona robi te dane
    public static ObservableList<Miejscowosc> data;

    {
        try {
            data = Main.getRows();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox(10);

        //przycisk odswierz
        Button refreshButton = new Button("Odśwież");
        refreshButton.setOnAction(e -> refresh());


        Button showFilesButton = new Button("Wybierz plik!");
        Label filesLabel = new Label();

        Label messagelabel = new Label();

        showFilesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("DB files", "*.db"));

                File selectedFile = fileChooser.showOpenDialog(primaryStage);
                textField.setText(String.valueOf(selectedFile));

                if ((textField.getText() != null && !textField.getText().isEmpty())) {
                    Main.setDbUrl("jdbc:sqlite:" + textField.getText());
                    messagelabel.setText("Twoja sciezka do pliku!\n" + textField.getText());
                } else {
                    textlabel.setText("cosik nie dziala");
                }

                refresh();
//        if (selectedFile != null) {
//            vbox.ad
//            primaryStage.display(selectedFile);
//        }
            }
        });


//        //dzialanie przycisku
//        try {
//            submitbutton.setOnAction(new EventHandler<ActionEvent>() {
//
//                @Override
//                public void handle(ActionEvent actionEvent) {
//                    if ((textField.getText() != null && !textField.getText().isEmpty())) {
//                        Main.setDbUrl("jdbc:sqlite:"+textField.getText());
//                        messagelabel.setText("Twoja sciezka do pliku!\n" +textField.getText());
//                    } else {
//                        textlabel.setText("cosik nie dziala");
//                    }
//                }
//            });
//        } catch (Exception e) {
//            System.out.println("Błąd bazy");
//        }

        vbox.getChildren().addAll(table);
//        vbox.getChildren().add(refreshButton);
        vbox.getChildren().addAll(textlabel, textField);
//        vbox.getChildren().add(submitbutton);
        vbox.getChildren().add(showFilesButton);
        vbox.getChildren().addAll(filesLabel);
        vbox.getChildren().addAll(messagelabel);
        vbox.setSpacing(10);
        Scene scene = new Scene(vbox, 650, 650);
        primaryStage.setTitle("Tabela miejscowosci");
        primaryStage.setScene(scene);

        primaryStage.show();


        refresh();
    }

    private static void refresh() {
        table.getItems().clear(); // Wyczyść istniejące dane
        table.getColumns().clear(); // Wyczyść istniejące kolumny
        ObservableList<Miejscowosc> data;
        {
            try {
                data = Main.getRows();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        //ogolnie wszystko na stringach bo z intami duzo zabawy
        // kolumna id
        TableColumn<Miejscowosc, String> idCol = new TableColumn<>("ID");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        // kolumna nazwy
        TableColumn<Miejscowosc, String> nazwaCol = new TableColumn<>("Nazwa");
        nazwaCol.setMinWidth(100);
        nazwaCol.setCellValueFactory(new PropertyValueFactory<>("nazwa"));


        table.setItems(data);
        table.getColumns().addAll(idCol, nazwaCol);

    }
}
