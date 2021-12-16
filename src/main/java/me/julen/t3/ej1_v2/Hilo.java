package me.julen.t3.ej1_v2;

import java.util.Random;

public class Hilo implements Runnable{
    String name;
    Random r = new Random();
    Hilo(String name) {
      this.name = name;
    }

    @Override
    public void run() {
      System.out.println(name + ": " + r.nextInt());
    }
}
