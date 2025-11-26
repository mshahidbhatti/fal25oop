package interface2;

public class MyComparator <T>{
    T t;
    MyComparator(T t){
        this.t=t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
