package org.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserLogin extends Application  {
    ArrayList<String> list=new ArrayList<>();
    ArrayList<User> userList1=new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception, IOException {
        GridPane layout=new GridPane();


        Scene scene1=new Scene(layout,500,500);
        TextField usernameField=new TextField();
        TextField passwordField=new TextField();

        Button saveButton=new Button("Save");
        layout.add(usernameField,0,1);
        layout.add(passwordField,0,2);
        layout.add(saveButton,0,3);

        File file=new File("user.dat");

        saveButton.setOnAction((e)-> {
            if(!usernameField.getText().isEmpty()&& !passwordField.getText().isEmpty()) {
                writeToFile(file, usernameField.getText() + " " + passwordField.getText());
                userList1.add(new User(usernameField.getText(),passwordField.getText()));
                usernameField.setText("");
                passwordField.setText("");
            }

        });

        Button readButton=new Button("Read");
        layout.add(readButton,0,4);
        readButton.setOnAction((e)->list=readFromFile(file));

        Button loginButton=new Button("Login");
        layout.add(loginButton,0,5);
        loginButton.setOnAction((e)-> System.out.println(list.contains(usernameField.getText()+" "+passwordField.getText())));


        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public static void writeToFile(File file,String data1){
        //file.createNewFile();
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data1);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch (IOException e){

        }

    }

    public static ArrayList<String> readFromFile(File file){
        ArrayList<String> userList=new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text="";
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine())
                userList.add(scanner.nextLine());

//            while((text=bufferedReader.readLine())!=null) {
//
//                userList.add(text);
//            }
            scanner.close();
            fileReader.close();
            bufferedReader.close();
        }
        catch (IOException e){

        }
        return userList;
    }
}
