package interfacePack;

public class Main {
    public static void main(String[] args) {
        DisplayText displayText=new DisplayText();

        displayText.printIt("text from abstract");

        PrintClass printClass =new PrintClass();
        printClass.printText("interface text");
        PrintInterface printInterface=new PrintClass();
        printInterface.printText("abc ...");

        DisplayText displayText1=new PrintClass();


    }
}
