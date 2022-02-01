package me.julen.t3.ej5;

public class Consumidor implements Runnable {

    Material zapato;

    Consumidor(Material zapato) {
        this.zapato = zapato;
    }

    @Override
    public void run() {
        int num;
        for(int i = 0; i < 50; i++) {
            synchronized(zapato) {
                while (zapato.getSize() < 1) {
                    try {
                        zapato.wait();
                    } catch(InterruptedException e) {
                    }
                }
            }
            num = zapato.coger();
            System.out.println("[C] Se ha cogido el numero " + num);
            synchronized(zapato) {
                zapato.notify();
            }
            try {
                Thread.sleep((int)(Math.random() * 2000));
            } catch( InterruptedException e ) {
            }
        }
    }
    
}
