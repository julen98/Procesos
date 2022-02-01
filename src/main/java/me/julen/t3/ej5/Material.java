package me.julen.t3.ej5;

import java.util.ArrayList;

public class Material {
    ArrayList<Integer> array = new ArrayList<Integer>();
    
    Material() {
    }

    public int getSize() {
        return array.size();
    }

    public synchronized int coger() {
        int num = array.get(0);
        array.remove(0);
        return num;
    }

    public synchronized void dejar(int num) {
        array.add(num);
    } 

}
