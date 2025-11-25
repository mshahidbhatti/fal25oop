package org.example;

public class PrintText1 extends PrintText{
    @Override
    public void printThings(String text) {
        System.out.println(text);
    }
    @Override
    public void add(int a, int b){
        System.out.println(a+b);
    }
}
