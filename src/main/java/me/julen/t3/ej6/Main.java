package me.julen.t3.ej6;

import javax.xml.transform.stream.StreamSource;

public class Main {
    public static void main(String[] args) {
        ThreadGroup subgrupo1 = new ThreadGroup("subgrupo1");
        ThreadGroup subgrupo2 = new ThreadGroup("subgrupo2");

        Thread hilo1 = new Thread(subgrupo1, "Hilo 1");
        Thread hilo2 = new Thread(subgrupo1, "Hilo 2");
        Thread hilo3 = new Thread(subgrupo2, "Hilo 3");

        ThreadGroup grupoActivo = Thread.currentThread().getThreadGroup();
        System.out.println("Grupo activo: " + grupoActivo);
        System.out.println("Numero de grupos activos: " + grupoActivo.activeGroupCount());

        grupoActivo.list();

        System.out.println("Prioridad grupo main: " + grupoActivo.getMaxPriority());
        System.out.println("Prioridad subgrupo 1: " + subgrupo1.getMaxPriority());
        System.out.println("Prioridad subgrupo 2: " + subgrupo2.getMaxPriority());

        subgrupo1.setMaxPriority(1);
        subgrupo1.setMaxPriority(2);

        System.out.println("Prioridad subgrupo 1: " + subgrupo1.getMaxPriority());
        System.out.println("Prioridad subgrupo 2: " + subgrupo2.getMaxPriority());

        System.out.println("Nombre grupo main: " + grupoActivo.getName() + " | Padre grupo main: " + grupoActivo.getParent());
        System.out.println("Nombre grupo subgrupo 1: " + subgrupo1.getName() + " | Padre grupo subgrupo 1: " + subgrupo1.getParent());
        System.out.println("Nombre grupo subgrupo 2: " + subgrupo2.getName() + " | Padre grupo subgrup 2: " + subgrupo2.getParent());

        if (subgrupo1.parentOf(grupoActivo)) {
            System.out.println("Subgrupo 1 es padre del hilo main");
        } else {
            System.out.println("Subgrupo 1 no es padre del hilo main");
        }

        if (subgrupo2.parentOf(grupoActivo)) {
            System.out.println("Subgrupo 2 es padre del hilo main");
        } else {
            System.out.println("Subgrupo 2 no es padre del hilo main");
        }

        if (grupoActivo.parentOf(subgrupo1)) {
            System.out.println("Subgrupo 1 es hijo del hilo main");
        } else {
            System.out.println("Subgrupo 1 no es hijo del hilo main");
        }

        if (grupoActivo.parentOf(subgrupo2)) {
            System.out.println("Subgrupo 2 es hijo del hilo main");
        } else {
            System.out.println("Subgrupo 2 no es hijo del hilo main");
        }
    }
}
