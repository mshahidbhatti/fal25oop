public class Student{

	private String id;
	private String name;
	private Date dob;
	private Address address;

	private Gender gender;
	private static int counter=1;
	Student(String name, Gender gender, Date dob, Address address){

		id=String.format("SP25-BCS-%03d",counter++);
		this.name="no name";
		this.gender=gender;
		this.dob=dob;
		this.address=address;
	}

	Student(){

		id=String.format("SP25-BCS-%03d",counter++);
		name="no name";
		gender=Gender.Male;
		this.dob=new Date(1,1,1);
		this.address=address;
	}
	public String getId(){
		return id;

	}

	@Override
	public String toString(){
		return String.format("%s\t %s %s %s %s", id, name, gender, dob, address);

	}


	@Override
	public boolean equals(Object o){
		Student st=(Student)o;

		return this.id.equals(st.getId());

	}

}