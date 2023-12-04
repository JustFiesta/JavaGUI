package com.example.javafx.Labs.no5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;

public class TableViewTest extends Application {
    private ObservableList<Worker> data = FXCollections.observableArrayList(
      new Worker("Fifonż", "Nowakowski", "Stolarz", 'M', true, LocalDate.of(2020, 2, 10)),
      new Worker("Linda", "Kowalska", "Sekretarka", 'F', false, LocalDate.of(2022, 8, 3)),
      new Worker("Alfons", "Piotrkowski", "Ochroniarz", 'M', true, LocalDate.of(2021, 5, 30))
    );

    //table for tableView
    private final TableView<Worker> table = new TableView<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        //columns for tableView
        TableColumn<Worker, String> nameCol = new TableColumn<Worker, String>("Imię");
        nameCol.setMaxWidth(100);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        TableColumn<Worker, String> secondName = new TableColumn<Worker, String>("Nazwisko");
        secondName.setMaxWidth(100);
        secondName.setCellValueFactory(
                new PropertyValueFactory<>("secondName")
        );

        TableColumn<Worker, String> occupationCol = new TableColumn<Worker, String>("Zawód");
        occupationCol.setMaxWidth(100);
        occupationCol.setCellValueFactory(
                new PropertyValueFactory<>("occupation")
        );

        TableColumn<Worker, Character> sexCol = new TableColumn<Worker, Character>("Płeć");
        sexCol.setMaxWidth(100);
        sexCol.setCellValueFactory(
                new PropertyValueFactory<>("sex")
        );

        TableColumn<Worker, Boolean> activeCol = new TableColumn<Worker, Boolean>("Aktywny zawodowo");
        activeCol.setMaxWidth(100);
        activeCol.setCellValueFactory(
                new PropertyValueFactory<>("active")
        );

        TableColumn<Worker, LocalDate> birthCol = new TableColumn<Worker, LocalDate>("Data Urodzenia");
        birthCol.setMaxWidth(100);
        birthCol.setCellValueFactory(
                new PropertyValueFactory<>("birthDate")
        );

        //add items to columns
        table.setItems(data);
        table.getColumns().addAll(nameCol, secondName, occupationCol, sexCol, activeCol, birthCol);

        //root node - 1st step
        VBox root = new VBox(10);

        //Main scene - 2nd step
        Scene scene = new Scene(root, 600 ,600);

        //Primary stage parameters - preparation of scene and contents (table, etc)
        primaryStage.setTitle("Workers");

        //Menu
        MenuBar menuBar = new MenuBar(); // main menu container - menu bar
        Menu menu = new Menu("File"); // categories container

        MenuItem save = new MenuItem("Save");
        MenuItem load = new MenuItem("Load");

        menu.getItems().addAll(save, load); // add options to menu category
        menuBar.getMenus().add(menu); // add menu category to main menu bar

        //menu acitons

        //add children nodes - 3rd
        root.getChildren().add(menuBar);
        root.getChildren().add(table);

        //show stage - 4th step
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void saveWorkerList(Stage stage){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        File workerList = fileChooser.showOpenDialog(stage);
        System.out.println(workerList);

    }
    public static void loadWorkerList(){

    }
}
