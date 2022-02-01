package me.julen.t3.ej3;

public class Client extends Thread {
    Avion avion;
    
    Client(String name, Avion avion) {
        super(name);
        this.avion = avion;
    }
    
    @Override
    public synchronized void run() {
        avion.nuevaReserva(1);
    }
}
