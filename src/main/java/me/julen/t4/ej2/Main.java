package me.julen.t4.ej2;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
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
                    tipo = connection.getContentType();
                    System.out.println("Tipo: " + tipo);

                    if(tipo.matches("/^image.*$/")) {
                        System.out.println("Peso: " + connection.getContentLength());
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
