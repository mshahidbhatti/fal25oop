package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        PrintText1 printText1 = new PrintText1();
        printText1.printThings("Text ..");


        PrintText printText = new PrintText1();
        printText.printThings("Text 2...");
    }
}