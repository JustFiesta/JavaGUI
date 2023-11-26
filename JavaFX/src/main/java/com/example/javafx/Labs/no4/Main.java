package com.example.javafx.Labs.no4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Date;

//step 0 - gui app needs to extend Application and implement start method - launched in main with args
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        //name for window
        primaryStage.setTitle("Hello Wojak!");

        //root node for all buttons, text labels, etc
        VBox root = new VBox();
        root.setSpacing(5.0);
//        Group root = new Group();

        //we need scene for root node
        Scene scene = new Scene(root, 600, 600, Color.WHITE);


        //drawing shapes
        Line blueline = new Line(100.0, 100f, 200f, 50f);
        blueline.setStroke(Color.GREEN);
        Rectangle square = new Rectangle(100.0, 100.0, Color.RED);
        Circle circle = new Circle(50.0, Color.BLUE);
        Polygon triangle = new Polygon(
                200.0, 200.0,
                250.0, 200.0,
                225.0, 250.0
        );
        triangle.setFill(Color.YELLOW);


        //adding icon
        Image icon = new Image("C:\\Users\\Masti\\Desktop\\Programowanie\\Java\\JavaGUI\\JavaFX\\src\\wojak.png");
        primaryStage.getIcons().add(icon);


        //adding text
        Text text = new Text("Hello!");
        text.setFont(Font.font("Lato", 40));
        text.setOpacity(0.6);
        text.setRotate(45.0);


        //controls
        Slider size = new Slider(0, 100, 50);
        Label sizeInfo = new Label("Set radius: "); //label
        Label sizeValue = new Label(Double.toString(size.getValue())); //info of choosen value

        size.setPrefSize(100.0, 5.0);

        size.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        sizeValue.setText(String.format(String.valueOf(newValue)));
                        changeRadius(circle, sizeValue.getText());
                    }
                }
        );


        //menu
        MenuBar mainMenu = new MenuBar(); //create menu bar container for menu objects
        Menu fileMenu = new Menu("File menu"); //create menu category container

        MenuItem newFile = new MenuItem("New"); //create menu options
        MenuItem saveFile = new MenuItem("Save");
        MenuItem removeFile = new MenuItem("Remove");
        MenuItem exitMenu = new MenuItem("Exit");

        fileMenu.getItems().addAll(newFile, saveFile, removeFile, exitMenu); //add menu options to menu category
        mainMenu.getMenus().add(fileMenu); //add menu category to menu bar

        //menu actions
        newFile.setOnAction(actionEvent -> new Alert(Alert.AlertType.INFORMATION).setContentText("New file would be created"));
        exitMenu.setOnAction(actionEvent -> Platform.exit());


        //forms
        Label nameLabel = new Label("Name:");
        TextField name = new TextField();
        Label secondNameLabel = new Label("Second name:");
        TextField secondName = new TextField();
        ObservableList<String> occupations = FXCollections.observableArrayList(
          "Mechanik",
                "Stolarz",
                "Piekarz"
        );
        Label occupationLabel = new Label("Occupation:");
        ComboBox<String> occupation = new ComboBox<>(occupations);
        occupation.getItems().addAll(
                "Ślusarz",
                "Kierowca"
        );
        Label birthDateLabel = new Label("Birth date:");
        DatePicker birthDate = new DatePicker();
        birthDate.setPromptText("Set birth date");
//        Label passwordLabel = new Label("Password:");
//        PasswordField password = new PasswordField();
        Label experienceLabel = new Label("Experience:");
        TextField experience = new TextField();

        Button addEmployee = new Button("Add");
        addEmployee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Worker newWorker = new Worker(name.getText(), secondName.getText(), occupation.getValue(), Integer.parseInt(experience.getText()), birthDate.getValue());
                System.out.println("Created a new worker!");
            }
        });

        //last step - add elements to root node
        root.getChildren().add(blueline);
        root.getChildren().add(square);
        root.getChildren().add(circle);
        root.getChildren().add(triangle);
        root.getChildren().add(text);
        root.getChildren().addAll(sizeInfo, size, sizeValue); //one line for properties (label, property field, value)
        root.getChildren().add(mainMenu);
        root.getChildren().addAll(nameLabel, name, secondNameLabel, secondName, occupationLabel, occupation, birthDateLabel, birthDate, experienceLabel, experience, addEmployee);
//        root.getChildren().addAll(passwordLabel, password);

        //1st step - always show stage (app window)
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void changeRadius(Circle circle, String sizeValue) {
        circle.setRadius(Double.parseDouble(sizeValue));
    }
}
