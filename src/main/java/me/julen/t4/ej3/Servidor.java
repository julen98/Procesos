package me.julen.t4.ej3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    private ServerSocket socket;
    private int puerto;
    private ArrayList<Cliente> clientes;

    public Servidor(int puerto) {
        this.puerto = puerto;
        clientes = new ArrayList<Cliente>();
    }

    public void iniciar() throws IOException {
        socket = new ServerSocket(puerto);
    }

    public void parar() throws IOException {
        socket.close();
    }

    public boolean estaConectado() {
        return !socket.isClosed();
    }

    public Socket aceptarConexion() throws IOException {
        return socket.accept();
    }

    public void anadirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void enviarMensajeATodos(String mensaje) throws IOException {
        for (Cliente cliente : clientes) {
            cliente.salida.writeUTF(mensaje);
        }
    }
}
