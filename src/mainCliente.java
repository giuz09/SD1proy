import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class mainCliente {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Avion a = new Avion("127.0.0.1", 2000);
		Pista p = new Pista(null) ;
		/////////////////////////////////////
		Random tiempoRandom = new Random ();
		Timer time = new Timer();
		TimerTask lanzadorAvion = new TimerTask() {
	
			public void run() {
				System.out.println("Se lanzo un avion");
				try {
					a.solicitarPista(p, a);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
		};	
		time.schedule(lanzadorAvion, tiempoRandom.nextInt(10)); //cuenta un tiempo random y llama al run de contador	
		////////////////////////////////////////////
	
	}
	
	
}
