package com.santacruzinstruments.scicalibrator.nmea2000.N2KLib.N2KLib;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MultivaluedHashMap<K, V> {
    private final HashMap<K, LinkedList<V>> delegate = new HashMap<>();

    public void add(K key, V value) {
        if( delegate.containsKey(key)){
            Objects.requireNonNull(delegate.get(key)).add(value);
        }else{
            LinkedList<V> l = new LinkedList<>();
            l.add(value);
            delegate.put(key, l);
        }
    }

    public List<V> get(K key) {
        return delegate.get(key);
    }

    public void clear(K key){
        LinkedList<V> l = new LinkedList<>();
        delegate.put(key, l);
    }
}
