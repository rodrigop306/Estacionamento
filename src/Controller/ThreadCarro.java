package Controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	private int idCarro;
	private Semaphore semaforo;
	private static int posChegada;
	private static int posSaida;
	public ThreadCarro(int idCarro, Semaphore semaforo) {
		// TODO Auto-generated constructor stub
		this.idCarro=idCarro;
		this.semaforo=semaforo;
	}
	public void run() {
		carroAndando();
		try {
			semaforo.acquire();
			carroParado();
			carroSaindo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			semaforo.release();
		}
		
	}
	private void carroAndando(){
		int distanciaFinal=(int)(Math.random()*2001)+1000;
		int distanciaPercorrida=0;
		int deslocamento=(int)(Math.random()*6)+35;
		int tempo=30;
		while(distanciaPercorrida<distanciaFinal){
			distanciaPercorrida+=deslocamento;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Carro %"+idCarro+ " andou "+distanciaPercorrida+" metros");
		}
		posChegada++;
		System.out.println("Carro %"+idCarro+" foi o "+posChegada+ "º a chegar");
		
	}
	private void carroParado(){
		System.out.println("Carro %"+idCarro+" estacionou");
		int tempoEspera = (int)(Math.random()*2501)+500;
		try {
			Thread.sleep(tempoEspera);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void carroSaindo(){
		posSaida++;
		System.out.println("Carro %"+idCarro+" foi o "+ posSaida+"º a sair");
	}
}
