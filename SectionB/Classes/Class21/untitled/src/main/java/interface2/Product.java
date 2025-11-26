package interface2;

import java.util.Comparator;

public class Product implements Comparable, Comparator {
    int id;
    String name;
    int rating;
    double price;

    public Product(int id, String name, int rating, double price) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.price = price;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int compareTo(Object otherProduct1){
        Product otherProduct=(Product) otherProduct1;
        int result=0;
        if(this.getRating()> otherProduct.getRating())
            result=1;
        if(this.getRating()< otherProduct.getRating())
            result=-1;
        if(this.getRating()== otherProduct.getRating())
            result=0;
        return result;

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }

    public int compare(Object o1, Object o2){
        Product otherProduct=(Product) o2;
        Product thisProduct=(Product) o1;

        int result=0;
        if(thisProduct.getPrice()> otherProduct.getPrice())
            result=1;
        if(thisProduct.getPrice()< otherProduct.getPrice())
            result=-1;
        if(thisProduct.getPrice()== otherProduct.getPrice())
            result=0;
        return result;
    }

    public boolean equals(Object o){

        Product p=(Product) o;
        return this.getId()==p.getId();
    }
}
