package org.example.gui01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Stack;

public class Gui01 extends Application {

    @Override
    public void start(Stage primaryStage){
        FlowPane flowPane=new FlowPane();
        Scene scene=new Scene(flowPane, 400, 300);
        Button button=new Button("Clcik Here");
        Button button2=new Button("Second button");
        flowPane.getChildren().addAll(button,button2);
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    public static void main(String[] args) {

        launch(args);
    }

}
