package View;

import java.util.concurrent.Semaphore;
import Controller.ThreadCarro;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int permissoes=2;
		Semaphore semaforo = new Semaphore(permissoes);
		for(int i=1;i<=5;i++){
			Thread t = new ThreadCarro(i, semaforo);
			t.start();
		}
	}

}
