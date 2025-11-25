package interfacePack;

public class PrintClass extends DisplayText implements PrintInterface{
    @Override
    public void printText(String text) {
        System.out.println(text);
    }
}
