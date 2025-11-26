package interface2;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Product p1=new Product(1,"Keyboard",3,500);
        Product productList[]=new Product[100];
        productList[0]=new Product(1,"Keyboard",4,500);
        productList[1]=new Product(1,"screen",3,9000);

        //System.out.println(productList[0].compare(productList[1]));

        ArrayList<Product> list1=new ArrayList<>();
        list1.add(productList[0]);
        list1.add(productList[1]);

        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);

        list1.sort(productList[0]);
        System.out.println(list1);

        Collections.reverse(list1);

        list1.sort(new ProductComparator());

        MyComparator<String > myComparator=new MyComparator<>("asdf");

        Pair<String, Integer>  phone=new Pair<>("name",123);

        Pair  phone1=new Pair("name",123);




    }
}
