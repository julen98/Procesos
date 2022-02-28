package me.julen.t4.ej3.Servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorHilo extends Thread {
    private Socket socket;
    private ArrayList<ServidorHilo> listaHilos;
    private PrintWriter output;
    public int numero = 0;
    public int suma = 0;

    public ServidorHilo(Socket socket, ArrayList<ServidorHilo> listaHilos) {
        this.socket = socket;
        this.listaHilos = listaHilos;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            output = new PrintWriter(socket.getOutputStream());

            while (true) {
                String outputString = input.readLine();
                try{
                    numero = Integer.parseInt(input.readLine());
                    suma = suma + numero;
                } catch (NumberFormatException ex){}

                if (outputString.equals("=")) {
                    System.out.println("Suma total: " + suma);
                    break;
                }
                printClientes(outputString);
                System.out.println("Servidor ha recibido: " + outputString);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void printClientes(String outputString) {
        for (ServidorHilo servidor : listaHilos) {
            servidor.output.println(outputString);
        }
    }
}
