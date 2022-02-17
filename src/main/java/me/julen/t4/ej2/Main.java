package me.julen.t4.ej2;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.ConnectIOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            boolean end = false;
            String input;
            Scanner teclado = new Scanner(System.in);
            String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
            String tipo;
            

            while (!end) {
                System.out.println("Introduce la url: ");
                input = teclado.nextLine();

                if(input.equals("exit") || input.equals("quit")) {
                    end = true;
                } else if (input.matches(regex)) {
                    end = false;
                    URL url = new URL(input);
                    URLConnection connection = url.openConnection();
                    tipo = connection.getContentType().toString();
                    System.out.println("Tipo: " + tipo);
                    String[] partes = tipo.split("/");
                    String subtipo = partes[0];
                    
                    if (subtipo.equals("image") || subtipo.equals("video")) {
                        double peso = connection.getContentLengthLong() / 1000000;
                        System.out.println("Peso: " + peso + " MB");
                    } else if (subtipo.equals("text")) {
                        System.out.println("Codificación: " + connection.getContentEncoding());
                    } else {
                        double peso = connection.getContentLengthLong() / 1000000;
                        System.out.println("Peso: " + peso + " MB");
                        System.out.println("Fecha de modificación: " + connection.getLastModified());
                    }
                } else {
                    System.out.println("La URL introducida es incorrecta.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
