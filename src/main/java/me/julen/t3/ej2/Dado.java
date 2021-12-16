package me.julen.t3.ej2;

import java.util.Random;

public class Dado extends Thread {
    Acumulador acumulador = new Acumulador();
    Random random = new Random();
    
    Dado(String name, Acumulador acumulador) {
        super(name);
        this.acumulador = acumulador;
    }

    @Override
    public void run() {
        int r = random.nextInt(6)+1;
        acumulador.setAcumulador(r);
        System.out.println("Tirada hilo " + this.getName() + ": " + r);
    }
}
