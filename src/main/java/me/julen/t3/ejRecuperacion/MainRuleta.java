package me.julen.t3.ejRecuperacion;

public class MainRuleta {

	public static void main(String[] args) {
		
		int bancoInicial = 1000;
		int apuestaInicial = 1;
		int maxTiradas = 50;
		
		Ruleta r = new Ruleta (maxTiradas);
		
		//Client(nom, ruleta, bank_inicial, aposta_inicial, metode, estrategia)
		Client cFC = new Client ("Client FC", r, bancoInicial, apuestaInicial, "F", "C");
		Client cFM = new Client ("Client FM", r, bancoInicial, apuestaInicial, "F", "M");
		Client cFD = new Client ("Client FD", r, bancoInicial, apuestaInicial, "F", "D");
		Client cAC = new Client ("Client AC", r, bancoInicial, apuestaInicial, "A", "C");
		Client cAM = new Client ("Client AM", r, bancoInicial, apuestaInicial, "A", "M");
		Client cAD = new Client ("Client AD", r, bancoInicial, apuestaInicial, "A", "D");
		
		//Llancem els fils i esperem fins que la partida acabe
		cFC.start();
		cFM.start();
		cFD.start();
		cAC.start();
		cAM.start();
		cAD.start();
		r.start();
	}
}
