package package2;

@FunctionalInterface
public interface PrintDefaultText {
    void printText();

    default void printIt(String text){
        System.out.println(text);
    }
}
