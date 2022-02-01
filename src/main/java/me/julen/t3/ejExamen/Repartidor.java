package me.julen.t3.ejExamen;

import java.util.Random;

public class Repartidor extends Thread {
    Tenda t;

    public Repartidor(String name, Tenda t) {
        super(name);
        this.t = t;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (t.comandasPreparadas < 30) {
            try {
                String comanda = t.recogerComanda(this.getName());
                sleep((r.nextInt(15) + 5) * 1000);
                t.repartirComanda(this.getName(), comanda);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
