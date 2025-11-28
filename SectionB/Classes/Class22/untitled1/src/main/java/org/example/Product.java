package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Product implements Comparator<Product>, Comparable<Product> {
    int id;
    String name;
    double price;
    int rating;

    public Product(int id, String name, double price, int rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compare(Product o1, Product o2) {
        int i=0;
        i=o1.getPrice()>o2.getPrice()?1:-1;
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
