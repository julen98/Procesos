package me.julen.t3.ej3;

public class Main {
    public static void main(String[] args) {
        Avion avion = new Avion();
        
        Client c1 = new Client("Cliente 1", avion);
        Client c2 = new Client("Cliente 2", avion);
        Client c3 = new Client("Cliente 3", avion);

        c1.start();
        c2.start();
        c3.start();
    }
}
