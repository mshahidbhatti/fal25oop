package org.example;

public abstract class PrintText implements AddThings{

    public void printDefault(){
        System.out.println("Print default text");
    }

    public abstract void printThings(String text);
}
