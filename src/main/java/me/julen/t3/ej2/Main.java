package me.julen.t3.ej2;

public class Main {
    public static void main(String[] args) {
        Acumulador a = new Acumulador();
        Dado d1 = new Dado("Dado 1", a);
        Dado d2 = new Dado("Dado 2", a);
        Dado d3 = new Dado("Dado 3", a);

        d1.start();
        d2.start();
        d3.start();
        
        try {
            d1.join();
            d2.join();
            d3.join();
        } catch (InterruptedException e) {
            System.err.println("Error en la tirada de dados: " + e);
        }
        
        System.out.println("Numero acumulado: " + a.getAcumulador());
    }
}
