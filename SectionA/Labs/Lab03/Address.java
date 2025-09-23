public class Address{
	String street;
	String city;
	String country;



	public boolean equals(Object o){
		Address address=(Address)o;
		return this.street.equals(address.getStreet());

	}

	

}