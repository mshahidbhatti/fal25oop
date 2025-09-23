package model;
public class Student {
    private static String id;
    private String name;
    private String gender;
    private String date;
    private String address;

    public Student(String name, String gender, String date, String address) {
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.address = address;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Student.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	public boolen equals(Object o){
	
		Student st= (Student)o;

		return this.id.equals(st.getID())&&this.name.equals(o.getName());
	}


}
