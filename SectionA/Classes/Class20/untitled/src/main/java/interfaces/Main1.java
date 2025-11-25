package interfaces;

public class Main1 {
    public static void main(String[] args) {
        GetSum getSum=(a,b)-> a+b;// lambda experssion
        System.out.println(getSum.add(3,4));

        displaySum(getSum);

    }


    public static void displaySum(GetSum getSum){
        System.out.println(getSum.add(2,3));
    }
}
