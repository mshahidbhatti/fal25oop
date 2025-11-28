package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Box<String> box=new Box<>("Hello generic");

            Box<Integer> boxInt=new Box<>(20);

        Pair<String, Integer> p1 = new OrderedPair<>("Even", 8);
        Pair<String, String>  p2 = new OrderedPair<>("hello", "world");

        OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>(23));

        Box<String> stringBox = new Box<>("adf");
        Box rawBox = stringBox;
        rawBox.setT(8);

        //System.out.println(rawBox.getT()+rawBox.getT());
    }
}