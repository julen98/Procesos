package me.julen.t4.ej3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    private Socket socket;
    BufferedReader entrada;
    DataOutputStream salida;

    public Cliente(Socket socket) throws IOException {
        this.socket = socket;
        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        salida = new DataOutputStream(socket.getOutputStream());
    }

    public boolean estaConectado() {
        return !socket.isClosed();
    }
}
