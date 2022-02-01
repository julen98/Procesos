package me.julen.t3.ej3;

public class Avion {
    int asientos = 5;
    
    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public void pagar() {
        try {
            System.out.println("Procesando el pago...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void reservarAsientos(int reservar) {
        asientos = asientos - reservar;
    }

    public synchronized void nuevaReserva(int reservar) {
        if(this.asientosLibres(reservar)) {
            System.out.println("Se van a reservar " + reservar + " asientos.");
            this.pagar();
            this.reservarAsientos(reservar);
            System.out.println("Quedan " + asientos + " asientos libres.");
        } else {
            System.out.println("No se ha podido reservar. Quedan " + asientos + " asientos libres.");
        }
    }

    public boolean asientosLibres(int reservar) {
        if (asientos >= reservar) {
            return true;
        } else {
            return false;
        }
    }
    
}
