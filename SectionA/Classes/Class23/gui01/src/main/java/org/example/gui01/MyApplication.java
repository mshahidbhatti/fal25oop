package org.example.gui01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MyApplication extends Application {

    @Override
    public void start(Stage primaryStage){

        FlowPane flowPane=new FlowPane();
        Scene scene =new Scene(flowPane, 200,200);
        Button button1=new Button("Click");

        flowPane.getChildren().add(button1);
        primaryStage.setTitle("GUI 01");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
