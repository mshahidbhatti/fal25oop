import java.time.LocalDate;
public class Grocery extends Product{
	LocalDate productionDate;
public Grocery(int id, String name, double price, String brand, String description, LocalDate productionDate) {
	super(id,name,price,brand,description);
	this.productionDate=productionDate;
    }
}