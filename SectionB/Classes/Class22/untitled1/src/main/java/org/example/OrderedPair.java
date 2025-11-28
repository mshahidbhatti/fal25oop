package org.example;

public class OrderedPair<K,V> implements Pair<K,V> {
    K k;
    V v;

    public OrderedPair(K k, V v) {
        this.k=k;
        this.v=v;
    }

    @Override
    public K getK() {
        return null;
    }

    @Override
    public V getV() {
        return null;
    }
}
