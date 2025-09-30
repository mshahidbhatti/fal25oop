public class Seat{

	private String seatID;
	private String type;
	private double price;
	private boolean isAvailable;
	Seat(String id, String type, double price, boolean isAvaialable){
		this.seatID=id;
		this.type=type;
		this.price=price;
		this.isAvailable=isAvaialable;
	}
	Seat(){}


@Override
public String toString(){
		return String.format("%s %s %.2f %b", seatID, type, price, isAvailable);
}

}