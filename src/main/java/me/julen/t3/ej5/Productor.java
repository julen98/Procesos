package me.julen.t3.ej5;

public class Productor implements Runnable {

    Material zapato;
    int num = 0;

    Productor(Material zapato) {
        this.zapato = zapato;
    }

    @Override
    public void run() {
        for(int i = 0; i < 50; i++) {
            num = (int)(10 * Math.random());
            
            synchronized (zapato) {
                while (zapato.getSize() >= 5) {
                    try {
                        zapato.wait();
                    } catch(InterruptedException e) {
                    }
                }
            }
            zapato.dejar(num);
            System.out.println("[P] Se ha producido el numero " + num);
            synchronized(zapato) {
                zapato.notify();
            }
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch(InterruptedException e) {
            }
        }
    }
}
