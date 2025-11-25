package package2;

public class Main2 {
    public static void main(String[] args) {

        AddThings addThings = (a,b)->{return (a+b);};

        addNumbers(addThings);
    }
    
    public static  void addNumbers(AddThings obj){
        System.out.println(obj.add(2,2));
    }
}
