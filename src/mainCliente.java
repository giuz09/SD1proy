import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class mainCliente {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Cliente c = new Cliente("192.168.237.229", 2000);
	
		/////////////////////////////////////
		Random tiempoRandom = new Random ();
		Timer time = new Timer();
		TimerTask lanzadorAvion = new TimerTask() {
	
			public void run() {
				System.out.println("Se lanzo un avion");
					
			}
		};	
		time.schedule(lanzadorAvion, tiempoRandom.nextInt(10)); //cuenta un tiempo random y llama al run de contador	
		////////////////////////////////////////////
	
	}
	
	
}
