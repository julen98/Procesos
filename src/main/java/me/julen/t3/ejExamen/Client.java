package me.julen.t3.ejExamen;

import java.util.Random;

public class Client extends Thread {
    Tenda t;

    Client(String name, Tenda t) {
        super(name);
        this.t = t;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            sleep((r.nextInt(60) + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.pedir(this.getName());
    }
    
}
