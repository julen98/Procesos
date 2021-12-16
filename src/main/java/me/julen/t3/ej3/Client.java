package me.julen.t3.ej3;

public class Client extends Thread {
    Avion avion;
    
    Client(String name, Avion avion) {
        super(name);
        this.avion = avion;
    }

    public void pagar() {
        try {
            System.out.println("Procesando el pago...");
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public synchronized void run() {
        avion.asientosLibres(1);
        pagar();
        avion.reservarAsientos(1);
    }
}
