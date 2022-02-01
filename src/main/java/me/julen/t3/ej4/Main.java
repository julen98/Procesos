package me.julen.t3.ej4;

public class Main {
    public static void main(String[] args) {
        Mensaje m = new Mensaje();

        new Thread(new Adeu("Adeu", m)).start();
        new Thread(new Hola("Hola", m)).start();
    }

}
