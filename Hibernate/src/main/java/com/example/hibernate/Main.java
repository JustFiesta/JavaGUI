package com.example.hibernate;

import javafx.application.Application;
import javafx.stage.Stage;
import org.hibernate.cfg.Configuration;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Configuration conf = new Configuration(); // checking if hibernate intellisence is working
    }

    public static void main(String[] args) {
        launch(args);
    }
}
