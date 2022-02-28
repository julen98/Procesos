package me.julen.t4.ej3.Cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5555)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            String userInput = "", respuesta;
            ClienteHilo cliente = new ClienteHilo(socket);
            new Thread(cliente).start();

            System.out.println("Que deseas hacer, modo suma o chat? (S para suma, C para chat)");
            respuesta = scanner.nextLine();
            do {
                if (respuesta.equalsIgnoreCase("S")) {
                    System.out.println(": ");
                    userInput = scanner.nextLine();
                    output.println(userInput);
                    if (userInput.equals("=")) {
                        break;
                    }
                } else if (respuesta.equalsIgnoreCase("C")) {
                    System.out.println(": ");
                    userInput = scanner.nextLine();
                    output.println(userInput);
                    if (userInput.equals("=")) {
                        break;
                    }
                }
            } while (!userInput.equals("="));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
