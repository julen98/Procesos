package me.julen.t4.ej3.Servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ServidorHilo> listaHilos = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(5555)) {
            while (true) {
                Socket socket = serverSocket.accept();
                ServidorHilo servidor = new ServidorHilo(socket, listaHilos);
                listaHilos.add(servidor);
                servidor.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
