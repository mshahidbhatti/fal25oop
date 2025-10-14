import java.time.LocalDate;
//LocalDate.now().plusDays(5)  //isAfter()
public class Product {
    protected int id;
    protected String name;
    protected double price;
    protected String brand;
    protected String description;

public Product(int id, String name, double price, String brand, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
    }

public Product(){}

    public void applyDiscount(double percent) {
        price -= price * percent / 100;
    }

    public double calculateTax() {
        return price * 0.10; 
    }

    public String getDetails() {
        return name + " (" + brand + ") - $" + price;
    }
}
