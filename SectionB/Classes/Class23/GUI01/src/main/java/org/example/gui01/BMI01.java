package org.example.gui01;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BMI01 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("BMI Calculator");
        
        Label nameLabel=new Label("Name");
        TextField nameField=new TextField();
        nameField.setPromptText("Enter Name");

    }


}
