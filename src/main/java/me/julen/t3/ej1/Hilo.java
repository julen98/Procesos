package me.julen.t3.ej1;

import java.util.Random;

public class Hilo extends Thread{

    Random r = new Random();
    Hilo(String name) {
        super(name);
    }
    @Override
    public void run() {
      System.out.println(this.getName() + ": " + r.nextInt());
    }
}
