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

public class Servidor extends UnicastRemoteObject implements TorreControl{
	//agreado por lo de rmi	
	private static final long serialVersionUID = 1L;
	Integer nroPuerto;
	String IP;
	Registry registro;
	//
	ArrayList<Avion> p = new ArrayList<Avion>();

//agreado por lo de rmi	
	public Servidor(Integer numeroPuertoRemoto) throws Exception {
		super();
		IP = InetAddress.getLocalHost().getHostAddress();
		nroPuerto = numeroPuertoRemoto;
		registro = LocateRegistry.createRegistry(nroPuerto);
		registro.bind("rmiServidor", this);
		System.out.println("Servidor inicializado en ip: " + IP + " puerto: " + nroPuerto);
	}

	public synchronized void atenderPeticion(Avion av) throws InterruptedException {

		while (p.size() >= 5) {
			try {
				System.out.println("El avion " + av.getCodigoAvion() + " esta esperando");
				wait();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		asignarPista(av);

	}

	public synchronized void asignarPista(Avion av) throws InterruptedException {
		p.add(av);
		System.out.println("Pista asignada al avion: " + av.getCodigoAvion());
		wait(10000);
		desasignarAvion(av);
	}

	public synchronized void desasignarAvion(Avion av) {
		p.remove(av);
		System.out.println("El avion: " + av.getCodigoAvion() + " se fue de la pista");
		notify();
	}

}
