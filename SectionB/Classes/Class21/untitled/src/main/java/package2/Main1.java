package package2;

public class Main1 {
    public static void main(String[] args) {
        PrintDefaultText printDefaultText =()-> System.out.println("text ....");


        printDefaultText.printText();

        PrintIt printIt = x -> System.out.println(x);
        printIt.printThis("abc");

    }
}
