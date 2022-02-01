package me.julen.t3.ejExamen;

import java.util.ArrayList;

public class Tenda {
    ArrayList<String> comandes;
    ArrayList<String> preparades;
    int nClients, comandasPreparadas, comandasRepartidas;

    public Tenda(int nClients) {
        this.nClients = nClients;
        comandes = new ArrayList<>();
        preparades = new ArrayList<>();
    }

    public synchronized void pedir(String cliente) {
        System.out.println(cliente + " ha pedido una comanda.");
        comandes.add(cliente);
    }

    public synchronized String cogerComanda(String treballador) {
        String comanda = comandes.get(0);
        comandes.remove(0);
        System.out.println(treballador + " ha cogido la comanda " + comanda + " - Comandas restantes: " + comandes.size());
        return comanda;
    }

    public synchronized void prepararComanda(String treb, String comanda) {
        System.out.println(treb + " ha preparado la comanda del " + comanda);
        preparades.add(comanda);
        comandasPreparadas++;
        notify();
    }

    public synchronized String recogerComanda(String repartidor) {
        while (preparades.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        String comanda = preparades.get(0);
        preparades.remove(0);
        comandasPreparadas--;
        System.out.println(repartidor + " ha cogido la comanda " + comanda + " - Comandas restantes: " + preparades.size());
        return comanda;
    }

    public synchronized void repartirComanda(String rep, String comanda) {
        System.out.println(rep + " ha repartido la comanda del " + comanda);
    }
}