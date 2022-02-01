package me.julen.t3.ejExamen;

import java.util.Random;

public class Treballador extends Thread {
    Tenda t;

    public Treballador(String name, Tenda t) {
        super(name);
        this.t = t;
    }

    @Override
    public void run() {
        Random r = new Random();
        
        while (t.comandes.size() > 0) {
            try {
                String comanda = t.cogerComanda(this.getName());
                sleep((r.nextInt(5) + 1) * 1000);
                t.prepararComanda(this.getName(), comanda);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
