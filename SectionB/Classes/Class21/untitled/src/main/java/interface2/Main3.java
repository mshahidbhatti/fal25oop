package interface2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Main3 {
    public static void main(String[] args) {
        Product p1=new Product(0,"laptop",3,10000);
        Product p2=new Product(1,"laptop",4,144000);
        Product p3=new Product(2,"connector",3,10000);
        Product p4=new Product(3,"keyboar",4,144000);


        List<Product> list=new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(1,p3);
        list.add(p4);
        System.out.println(list.size());
      //  System.out.println(list);


        ArrayList<Product> list2=new ArrayList<>(30);
        displayProducts(list);
      //  list.remove(1);
        list.sort(p1);
        Collections.sort(list);
        list.remove(p3);
        System.out.println();
        displayProducts(list);
        System.out.println(list.size());
        Iterator<Product> iterator=list.iterator();
        System.out.println(iterator.hasNext());


      //  System.out.println(list.get(20));

    }

    public static  void displayProducts(List<Product> list){

        for(Product temp: list)
            System.out.println(temp);

    }
}
