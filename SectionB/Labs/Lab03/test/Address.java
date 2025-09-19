public class Address{

	private String street;
	private String city;
	private String country;

	Address(String street, String city, String country){
		this.street=street;
		this.city=city;
		this.country=country;

	}

	@Override
	public String toString(){
		return String.format("%s\t%s\t%s",street,city,country);

	}


}