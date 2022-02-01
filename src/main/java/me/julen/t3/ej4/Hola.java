package me.julen.t3.ej4;

public class Hola implements Runnable {
    String nombre;
    Mensaje mensaje;
    
    Hola(String nombre, Mensaje mensaje) {
        this.nombre = nombre;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        mensaje.escribirHola();
    }
}
