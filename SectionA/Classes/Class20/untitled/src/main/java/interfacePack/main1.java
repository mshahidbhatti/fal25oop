package interfacePack;

public class main1 {
    public static void main(String[] args) {
        PrintThings printThings=new PrintThings() {
            @Override
            void printIt(String s) {
                System.out.println(s);
            }
        };

        printThings.printIt("text from inline function");


    }
}
