package org.example.gui002;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class BMICalculator extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane=new GridPane();
        primaryStage.setTitle("BMI Calculator");
        Scene scene1=new Scene(gridPane,1000,600, Color.AZURE);
        scene1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getX());
            }
        });
        FileInputStream fileInputStream=new FileInputStream("src/main/resources/banner.png");
        Image bannerImage=new Image(fileInputStream);
        ImageView bannerImageViewer=new ImageView(bannerImage);
        bannerImageViewer.setFitHeight(150);
        gridPane.add(bannerImageViewer,0,0,3,1);

        Label nameLabel=new Label("Name");
        TextField nameField=new TextField();
        nameField.setPromptText("Enter Name");
        gridPane.add(nameLabel,0,1);
        gridPane.add(nameField,1,1);
        gridPane.setVgap(15);
        gridPane.setHgap(15);

        DatePicker dob=new DatePicker();
        dob.setPromptText("Select DOB");

        gridPane.add(dob,1,2);

        RadioButton maleRadioButton=new RadioButton("Male");
        RadioButton femaleRadioButton=new RadioButton("Female");
        HBox genderBox=new HBox();
        genderBox.getChildren().addAll(maleRadioButton,femaleRadioButton);
        ToggleGroup toggleGroup =new ToggleGroup();
        maleRadioButton.setToggleGroup(toggleGroup);
        femaleRadioButton.setToggleGroup(toggleGroup);

        gridPane.add(genderBox,1,3);

        Slider weight=new Slider();
        weight.setShowTickLabels(true);
        weight.setShowTickMarks(true);
        weight.setMin(20);
        weight.setMax(200);

        gridPane.add(weight,1,4);
        Slider height=new Slider();

        height.setShowTickLabels(true);
        height.setShowTickMarks(true);
        height.setMin(140);
        height.setMax(200);
        height.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
            }
        });

        FileInputStream profile=new FileInputStream("C:\\Users\\mshah\\Downloads\\bmiresources\\profile.png");
        Image profileImage=new Image(profile);

        ImageView profileImageViewer=new ImageView(profileImage);
        profileImageViewer.setFitHeight(150);
        profileImageViewer.setFitWidth(150);
        gridPane.add(profileImageViewer,2,1,1,4);
        Button selectFileButton=new Button("Select Image");
        gridPane.add(selectFileButton,2,5);
        gridPane.add(height,1,6);
        final String[] path = {""};
        FileChooser fileChooser=new FileChooser();
        selectFileButton.setOnAction((e)->{fileChooser.showOpenDialog(primaryStage);
        if(fileChooser!=null)
            path[0] =fileChooser.getInitialFileName();
        });

        Button calculateButton=new Button("Calculate BMI");
        calculateButton.setOnAction((e)->{
            double h=height.getValue();
            double w=weight.getValue();
            System.out.println(h*w);

        });

        gridPane.add(calculateButton,2,6);

        Button nextButton=new Button("Next Scene");
        FlowPane flowPane=new FlowPane();
        Button backButton=new Button("Back");
        flowPane.getChildren().add(backButton);
        backButton.setOnAction((e)->primaryStage.setScene(scene1));
        Scene scene2=new Scene(flowPane,100,100);
        nextButton.setOnAction((e)->{primaryStage.setScene(scene2);
        primaryStage.setTitle(nameField.getText());
        });
        gridPane.add(nextButton,1,8);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

