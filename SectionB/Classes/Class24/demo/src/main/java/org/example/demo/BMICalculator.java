package org.example.demo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class BMICalculator extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane=new GridPane();
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\mshah\\Downloads\\bmiresources\\banner.png");

        Image banner=new Image(fileInputStream);
        Scene scene1=new Scene(gridPane,790,680);

        ImageView imageView=new ImageView(banner);
        imageView.setFitHeight(150);
        imageView.setFitWidth(790);


        TextField nameField=new TextField();
        nameField.setPromptText("Enter Name");
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        DatePicker dob=new DatePicker();
        dob.setPromptText("Date of Birth");
        gridPane.add(imageView,0,0,3,1);
        gridPane.add(nameField,0,1);
        gridPane.add(dob,0,2);
        primaryStage.setScene(scene1);

        RadioButton maleRadioButton=new RadioButton("Male");
        RadioButton femaleRadioButton=new RadioButton("Female");
        ToggleGroup genderToggleGroup=new ToggleGroup();
        maleRadioButton.setToggleGroup(genderToggleGroup);
        femaleRadioButton.setToggleGroup(genderToggleGroup);

        Label genderLabel=new Label("Gender");
        HBox genderHbox=new HBox();
        genderHbox.setSpacing(10);
        genderHbox.getChildren().addAll(genderLabel,maleRadioButton,femaleRadioButton);
        Slider weight=new Slider();

        weight.setShowTickMarks(true);
        weight.setShowTickLabels(true);

        weight.setMin(20);
        weight.setMax(100);
        //weight.setOrientation(Orientation.VERTICAL);

        weight.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
            }
        });
        gridPane.add(genderHbox,0,3);
        gridPane.add(weight,0,5,2,1);



        FileInputStream profileImage=new FileInputStream("C:\\Users\\mshah\\Downloads\\bmiresources\\profile.png");
        Image profile=new Image(profileImage);
        ImageView profileImageViewer=new ImageView(profile);
        profileImageViewer.setFitWidth(100);
        profileImageViewer.setFitHeight(100);
        FileChooser fileChooser=new FileChooser();
        //;

        gridPane.add(profileImageViewer,1,1,1,3);


        Button openFile=new Button("Choose Image");
        openFile.setOnAction((e)->fileChooser.showOpenDialog(primaryStage));
        primaryStage.setTitle("BMI Calculator");
        gridPane.add(openFile,1,4);

        primaryStage.show();

    }
}
