package org.example;

import java.util.Comparator;
import java.util.stream.Collector;

public class NameComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
