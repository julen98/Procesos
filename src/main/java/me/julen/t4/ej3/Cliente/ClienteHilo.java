package me.julen.t4.ej3.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteHilo implements Runnable {
    private Socket socket;
    private BufferedReader input;

    public ClienteHilo(Socket socket) throws IOException {
        this.socket = socket;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(input.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
