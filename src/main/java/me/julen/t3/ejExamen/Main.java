package me.julen.t3.ejExamen;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int nClients = 30;
        int nTreballadors = 3;
        int nRepartidors = 3;
        Client[] filsClients = new Client[nClients];
        Treballador[] filsTreballadors = new Treballador[nTreballadors];
        Repartidor[] filsRepartidors = new Repartidor[nRepartidors];
        Tenda t = new Tenda(nClients);
        
        for (int i = 0; i < nClients; i++) {
            filsClients[i] = new Client("Client " + (i + 1), t);
            filsClients[i].start();
        }

        for (int i = 0; i < nClients; i++) {
            filsClients[i].join();
        }

        System.out.println("MAIN: Los pedidos han sido realizados correctamente.");
        
        for (int i = 0; i < nTreballadors; i++) {
            filsTreballadors[i] = new Treballador("Treballador " + (i + 1), t);
            filsRepartidors[i] = new Repartidor("Repartidor " + (i + 1), t);
            filsTreballadors[i].start();
            filsRepartidors[i].start();
        }
        
        for (int i = 0; i < 3; i++) {
            filsTreballadors[i].join();
            filsRepartidors[i].join();
        }

        System.out.println("MAIN: Los repartidores han repartido todas las comandas.");
    }
}
