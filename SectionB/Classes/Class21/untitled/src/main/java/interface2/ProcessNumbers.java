package interface2;

public class ProcessNumbers <T  extends Number>{

    void sum(T t1, T t2)
    {

        System.out.println(t1.doubleValue()+t2.doubleValue());
    }
}
