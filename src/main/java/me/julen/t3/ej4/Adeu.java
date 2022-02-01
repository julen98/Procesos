package me.julen.t3.ej4;

public class Adeu implements Runnable {
    String nombre;
    Mensaje mensaje;

    Adeu(String nombre, Mensaje mensaje) {
        this.nombre = nombre;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        mensaje.escribirAdeu();
    }
}
