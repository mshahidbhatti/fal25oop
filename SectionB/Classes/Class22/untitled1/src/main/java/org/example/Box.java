package org.example;

public class Box<T> {

    T t;

    public Box(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
