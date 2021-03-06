package me.julen.t3.ejRecuperacion;

import java.util.Random;

public class Client extends Thread {
	//Atributs que venen en el constructor
	private String nombre;
	private Ruleta ruleta;
	private int bancoInicial;
	private int apuestaInicial;
	private String metodo;
	private String estrategia;

	//Altres atributs que s'utilitzen als metodes proporcionats
	private int numero;
	private int tiradas = 1;
	private int banco = bancoInicial;
	private float totalApostado;

	
	//Altres atributs que pugues necessitar
	int martingala = 1, dalembert = 1;
	int apuesta;
	
	public Client(String n, Ruleta r, int b, int a, String m, String e) {
		this.nombre = n;
		this.ruleta = r;
		this.bancoInicial = b;
		this.apuestaInicial = a;
		this.metodo = m;
		this.estrategia = e;
	}
	
	public void iniciar() {
		if (metodo == "F")
			System.out.println(nombre + " - Bank inicial: " + bancoInicial + " - numero: " + numero);
		else
			System.out.println(nombre + " - Bank inicial: " + bancoInicial + " euros.");
	}
	
	public void finalitzar() {
		System.out.println(nombre + ": He acabat la partida - Tirades: " + tiradas + " - Bank actual: " + banco + " euros.");
		System.out.println(nombre + ": Benefici: " + (banco - bancoInicial) + " euros. Rendiment: " + ((banco - bancoInicial) / totalApostado) * 100 + "%");
	}
	
	//Resta de metodes que pugues necessitar tant per a gestionar el client com per a la comunicacio amb la Ruleta
	Random r = new Random();
	int randomFijo = r.nextInt(36);

	public int numeroApuesta () {
		if (metodo == "F") {
			return randomFijo;
		} else {
			return (r.nextInt(36) + 0);
		}
	}

	public void apuesta() {
		if (estrategia.equals("D")){
			apuesta = dalembert;
			totalApostado = totalApostado + apuesta;
			
			if(numeroApuesta() == ruleta.generarNumero())
				dalembert = 1;
			else
				dalembert++;
		} else if (estrategia.equals("M")) {
			apuesta = martingala;
			totalApostado = totalApostado + apuesta;
			
			if(numeroApuesta() == ruleta.generarNumero())
				martingala = 1;
			else
				martingala = martingala * 2;
		} else {
			apuesta = 1;
			totalApostado = totalApostado + apuesta;
		}
	}

	public void actualizarBanco() {
		banco = banco - apuesta;
	}

	@Override
	public void run() {
		try {
			iniciar();
			banco = bancoInicial;
			while (ruleta.isAlive()) {
				ruleta.pararClientes();
				apuesta();
				banco = banco + ruleta.apostar(nombre, numeroApuesta(), apuesta);
				tiradas++;
				actualizarBanco();
				if (apuesta > banco) {
					finalitzar();
					join();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}