package org.example;

public class Main2 {
    public static void main(String[] args) {
        PrintText printText=new PrintText() {
            @Override
            public void printThings(String text) {

            }

            @Override
            public void add(int a, int b) {

            }
        };

        PrintText printText1=new PrintText1();
        printText1.add(2,2);

        AddThings addThings=new PrintText1();
        addThings.add(3,3);

        AddThings addThings1=new AddThings() {
            @Override
            public void add(int a, int b) {
                System.out.println(a+b);
            }
        };
        addThings1.add(1,2);


    }
}
