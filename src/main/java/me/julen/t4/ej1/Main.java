package me.julen.t4.ej1;

import java.net.InetAddress;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;
        Scanner teclado = new Scanner(System.in);
        InetAddress ip;
        
        // Bucle para pedir por pantalla el input
        try {
            do {
                System.out.print("nslookup ");
                input = teclado.nextLine();
                
                // Controla que si empieza por un numero muestre el host y si no muestre la ip
                if(!Character.isDigit(input.charAt(0))) {
                    ip = InetAddress.getByName(input);
                    System.out.println(ip.getHostAddress());
                } else {
                    ip = InetAddress.getByName(input);
                    System.out.println(ip.getHostName());
                }
            } while (!comprobador(input));
        } catch (Exception e) {
            e.printStackTrace();
        }
        teclado.close();
    }

    // Metodo para comprobar que el input es exit o quit
    public static boolean comprobador(String input) {
        if(input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
            return true;
        } else {
            return false;
        }
   }
}
