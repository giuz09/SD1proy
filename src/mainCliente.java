import java.lang.reflect.Array;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class mainCliente {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		final Avion A1 = new Avion("127.0.0.1", 2000,"A1");
		final Avion A2 = new Avion("127.0.0.1", 2000,"A2");
		final Avion A3 = new Avion("127.0.0.1", 2000,"A3");
		final Avion A4 = new Avion("127.0.0.1", 2000,"A4");
		final Avion A5 = new Avion("127.0.0.1", 2000,"A5");
		
		
		A1.solicitarPista(A1);
		A2.solicitarPista(A2);
		A3.solicitarPista(A3);
		A4.solicitarPista(A4);
		A5.solicitarPista(A5);
		
		/*
		 
		 Random tiempoRandom = new Random ();
		 
		Timer time = new Timer();
		TimerTask lanzadorAvion = new TimerTask() {
	
		
			
				public void run() {
				System.out.println("Se lanzo un avion");
				try {
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
		};	
		time.schedule(lanzadorAvion, tiempoRandom.nextInt(10)); //cuenta un tiempo random y llama al run de contador	
				
	*/
	}
	
	
	
	
	
	
	
}
