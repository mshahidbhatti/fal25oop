package org.example.demo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandlingGUI extends Application {
    ArrayList<String> users=new ArrayList<>();
    static ArrayList<Users> usersList=new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane layout=new GridPane();
        Scene scene1=new Scene(layout,500,500);
        TextField ueserTextField=new TextField();

        TextField passwordTextField=new TextField();

        Button saveButton=new Button("Save");



        File file=new File("data.xyz");
       // file.createNewFile();

        saveButton.setOnAction((e)->{
            if(!ueserTextField.getText().isEmpty()&&!ueserTextField.getText().contains(" ")&&!passwordTextField.getText().isEmpty()) {
                writeToFile(file, ueserTextField.getText() + " " + passwordTextField.getText());
                ueserTextField.setText("");
                passwordTextField.setText("");
            }
});


        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());


        layout.add(ueserTextField,0,1);
        layout.add(passwordTextField,0,2);
        layout.add(saveButton,0,3);


        Button readButton=new Button("Read");
        readButton.setOnAction((e)-> users=readFromFile(file));
        layout.add(readButton,0,4);

        Button loginButton=new Button("Login");
        loginButton.setOnAction((e)-> System.out.println(users.contains(ueserTextField.getText()+" "+passwordTextField.getText())));

        TableView<String> userTable=new TableView<>();
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");

        userTable.getColumns().addAll(firstNameCol,lastNameCol);



        layout.add(loginButton,0,5);
        layout.add(userTable,0,6);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void writeToFile(File file, String text){
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();
        }
        catch (IOException e){

        }

    }

    public static ArrayList<String> readFromFile(File file){
        ArrayList<String> list=new ArrayList<>();
        try{
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String text="";
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine())
            {
                String text1=scanner.nextLine();
                list.add(text1);
                String userDetails[]=text1.split(" ");
               usersList.add(new Users(userDetails[0],userDetails[1]));


            }
//           while((text=bufferedReader.readLine())!=null) {
//               System.out.println(text);
//               list.add(text);
//               String userDetails[]=text.split(" ");
//               usersList.add(new Users(userDetails[0],userDetails[1]));
//
//           }
            bufferedReader.close();
            fileReader.close();
        }
        catch (IOException e){

        }
        return list;
    }
}
