import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements TorreControl, Runnable{
	//agreado por lo de rmi	
	private static final long serialVersionUID = 1L;
	Integer nroPuerto;
	String IP;
	Registry registro;
	//
	ArrayList<Avion> p = new ArrayList<Avion>();
	
	
//agreado por lo de rmi	
	public Servidor (Integer numeroPuertoRemoto) throws Exception{
		super();
		IP = InetAddress.getLocalHost().getHostAddress();
		nroPuerto = numeroPuertoRemoto;
		registro = LocateRegistry.createRegistry(nroPuerto);
		registro.bind("rmiServidor", this);
		System.out.println("Servidor inicializado en ip: " + IP + " puerto: " + nroPuerto);
	}
	

	public void atenderPeticion (Avion av) {
		//recibe solicitud de avion solicitando pista
		//verifica si hay pista disponible	
		//Integer posicionPista =  posicionDisponiblePista();	
		while (p.size()==5) {
			//mientras la pista este llena espero que se desocupe un lugar
			
		}
		//cuando se va un avion notifica a todos que hay un lugar libre	
		
		p.add(av);
		administraAterrizajes(av);
		System.out.println("Pista asignada al avion: "+av.getCodigoAvion());		
					
	}


	
	public void administraAterrizajes(Avion av) {
		//cuentaTiempoEstacionado();este se remplaza po el wait
			
		p.remove(av);
		// tambien debe fijarse si hay alguien en la cola esperando 
		
	/*	if (colaTurnos.isEmpty()) {
			System.out.println("No hay aviones esperando en la cola");
		}
		else { 
			colaTurnos.remove(0);
			asignarPista(av); // y asigna ese avion a la pista
		}	*/
		
	}




}
