package org.example.gui01;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginForm extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridLayout=new GridPane();

        Scene scene=new Scene(gridLayout,500,400);

        Text welcomeText=new Text("Login Screen of Data Entry Form");
        welcomeText.setFont(new Font("Arial",20));
        gridLayout.setPadding(new Insets(20,20,20,20));
        //gridLayout.add(welcomeText,0,0);
        gridLayout.add(welcomeText,0,0,2,1);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        FlowPane flowPane=new FlowPane();
        Scene scene2=new Scene(flowPane,200,200);

        Label userLabel=new Label("User Name");
        TextField userTextField=new TextField();
        gridLayout.add(userLabel,0,1);
        gridLayout.add(userTextField,1,1);

        Label passwordLabel=new Label("Password");
        PasswordField passwordTextField=new PasswordField();

        gridLayout.add(passwordLabel,0,2);
        gridLayout.add(passwordTextField,1,2);

        Button cancelButton=new Button("Cancel");

        cancelButton.setOnAction((e)-> primaryStage.hide());
        Button loginButton=new Button("Login");
        loginButton.setOnAction((e)->primaryStage.setScene(scene2));

        //gridLayout.add(canelButton,1,3);

        //gridLayout.add(loginButton,2,3);

        HBox loginBox=new HBox();
        loginBox.setAlignment(Pos.BASELINE_RIGHT);
        loginBox.setSpacing(10);

        loginBox.getChildren().addAll(cancelButton,loginButton);
        gridLayout.add(loginBox,1,3);
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}
