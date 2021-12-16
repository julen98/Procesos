package me.julen.t3.ej3;

public class Avion {
    int asientos = 5;
    boolean comprobador;
    
    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public synchronized void reservarAsientos(int reservar) {
        if(comprobador = true) {
            asientos = asientos - reservar;
            System.out.println("Se han reservado " + reservar + " asientos.");
            System.out.println("Quedan " + asientos + " asientos libres.");
        } else {
            System.out.println("No se ha podido reservar.");
        }
    }

    public synchronized boolean asientosLibres(int reservar) {
        if (asientos > reservar) {
            System.out.println("Quedan " + asientos + " asientos libres, puedes reservarlos.");
            return comprobador = true;
        } else {
            System.out.println("No se pueden reservar el numero de asientos introducidos, solo quedan " + asientos);
            return comprobador = false;
        }
    }
    
}
