package me.julen.t3.ej4;

public class Mensaje {
    boolean comprobar = false;
    public synchronized void escribirAdeu() {
        while (!comprobar){
            try {
                wait();
            } catch (InterruptedException e) {
            }    
        }
        comprobar = false;
        System.out.println("Adeu");
    }

    public synchronized void escribirHola() {
        System.out.println("Hola");
        comprobar = true;
        notify();
    }
}
