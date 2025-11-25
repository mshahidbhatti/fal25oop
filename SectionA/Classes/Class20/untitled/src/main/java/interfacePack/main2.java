package interfacePack;

public class main2 {
    public static void main(String[] args) {

        PrintIt printIt = new PrintIt() {
            @Override
            public void printText(String text) {
                System.out.println(text);
            }
        };
        printIt.printText("text from interface");
        PrintIt printIt1 = e-> System.out.println(e);


        printIt1.printText("simple method");


    }
}
