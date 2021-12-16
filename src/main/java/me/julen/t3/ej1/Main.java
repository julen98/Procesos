package me.julen.t3.ej1;

public class Main {
    public static void main( String[] args ) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(new Hilo("Hilo " + i)).start();
        }
    }
}
