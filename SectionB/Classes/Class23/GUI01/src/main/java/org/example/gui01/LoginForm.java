package org.example.gui01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginForm extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane=new GridPane();
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        Scene scene1=new Scene(gridPane,500,400);
        FlowPane flowPane=new FlowPane();
        Scene scene2=new Scene(flowPane,200,200);
        Text welComeText=new Text("Welcome to CUI Data Entry Form");
        welComeText.setFont(new Font("Arial",20));
//gridPane.add(welComeText,0,0);


        gridPane.add(welComeText,0,0,2,1);
        Label userLabel=new Label("User Name");
        Label passwordLabel=new Label("Password");
        gridPane.add(userLabel,0,1);
        gridPane.add(passwordLabel,0,2);
        TextField userTextField=new TextField();
        PasswordField passwordTextField=new PasswordField();
        gridPane.setPadding(new Insets(30,30,30,30));

        Button exitButton=new Button("Exit");
        exitButton.setOnAction((e)-> primaryStage.hide());
        Button loginButton=new Button("Login");


        gridPane.add(userTextField,1,1);
        gridPane.add(passwordTextField,1,2);

        //gridPane.add(exitButton,1,3);
        //gridPane.add(loginButton,2,3);

        Button backButton=new Button("Back");
        Text text2=new Text("empty");
        loginButton.setOnAction((e)->{primaryStage.setScene(scene2);
            text2.setText(userTextField.getText());
        });

        flowPane.getChildren().addAll(text2,backButton);
        backButton.setOnAction((e)->primaryStage.setScene(scene1));
        HBox loginBox=new HBox();
//        loginBox.setBorder(new Border());
        loginBox.setAlignment(Pos.BASELINE_RIGHT);
        loginBox.setSpacing(15);
        loginBox.getChildren().addAll(exitButton,loginButton);
        gridPane.add(loginBox,1,3);
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
