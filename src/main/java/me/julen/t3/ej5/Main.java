package me.julen.t3.ej5;

public class Main {
    public static void main(String[] args) {
        Material material = new Material();
        Productor productor = new Productor(material);
        Consumidor consumidor = new Consumidor(material);
        Thread productorThread = new Thread(productor);
        Thread consumidorThread = new Thread(consumidor);
        
        productorThread.start();
        consumidorThread.start();
    }
}
