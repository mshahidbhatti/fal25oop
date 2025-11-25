package package2;

public class Main {
    public static void main(String[] args) {
        PrintDefaultText printDefaultText=new PrintDefaultText() {
            @Override
            public void printText() {
                System.out.println("Text from interface");
            }
        };

        printDefaultText.printText();
    }
}
