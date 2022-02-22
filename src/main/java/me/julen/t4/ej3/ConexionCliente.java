package me.julen.t4.ej3;

import java.io.IOException;

public class ConexionCliente extends Thread {

    private Cliente cliente;
    private Servidor servidor;

    public ConexionCliente(Cliente cliente, Servidor servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
        
    }

    @Override
    public void run() {
        try {
            cliente.salida.writeUTF(cliente.entrada.readLine());
            while (cliente.estaConectado()) {
                String mensaje = cliente.entrada.readLine();
                while (!mensaje.equals(".")) { 
                    servidor.enviarMensajeATodos(mensaje); 
                }
            }
            servidor.parar();
            cliente.entrada.close();
            cliente.salida.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}