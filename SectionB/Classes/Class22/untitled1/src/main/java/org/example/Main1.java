package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Main1 {
    public static void main(String[] args) {
        Product p1=new Product(0,"keyboard",100,3);
        Product p2=new Product(1,"laptop",400,3);
        Product p3=new Product(2,"wire",100,2);
        Product p4=new Product(3,"mouse",600,5);
        Product p5=new Product(4,"connector",100,3);

        ArrayList<Product> list=new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        System.out.println(list);


        list.remove(new Product(0,"keyboard",100,3));
        System.out.println();
        System.out.println(list);

        list.sort(p1);
        System.out.println(list);

        list.sort(new NameComparator());
        System.out.println(list);


        Collections.sort(list);






    }
}
