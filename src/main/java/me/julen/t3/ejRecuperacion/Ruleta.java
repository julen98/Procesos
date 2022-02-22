package me.julen.t3.ejRecuperacion;

import java.util.Random;

public class Ruleta extends Thread {
	
	//Atributs que venen en el constructor
	private int maxTiradas;

	//Altres atributs que s'utilitzen als metodes proporcionats
	private int tiradas = 1;
	
	//Altres atributs que pugues necessitar
	boolean permitir = false;

	public Ruleta(int nT) {
		maxTiradas = 50;
	}
	
	public void iniciar() {
		System.out.println("Comienza la partida");
	}
	
	public void finalitzar() {
		System.out.println("Fi de la partida - Tirades: " + tiradas);
	}
	
	//Resta de metodes que pugues necessitar per gestionar la Ruleta
	public int generarNumero() {
		Random r = new Random();
		return r.nextInt(36) + 0;
	}
	
	//Metode que executaran els clients per fer una aposta. La ruleta tornara el benefici obtingut en l'aposta
	public synchronized int apostar (String cliente, int numApuesta, int apuesta) {
		System.out.println(cliente + " aposta " + apuesta + " euro al numero " + numApuesta);
		if(numApuesta == generarNumero()) {
			return apuesta * 36;
		} else {
			return apuesta * 0;
		}
	}
	
	//Altres metodes que utilitzaran els Clients per comunicar-se amb la Ruleta
	
	public synchronized void avisarClientes() {
		System.out.println("Apuestas abiertas para la tirada " + tiradas);
		notifyAll();
	}

	public synchronized void pararClientes() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			iniciar();
			while (tiradas < maxTiradas) {
				generarNumero();
				avisarClientes();
				sleep(2000);
				System.out.println("Tirada " + tiradas + " - Numero: " + generarNumero());
				tiradas++;
			}
			finalitzar();
			yield();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
