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

public class Servidor extends UnicastRemoteObject implements TorreControl {
	//agreado por lo de rmi	
	private static final long serialVersionUID = 1L;
	Integer nroPuerto;
	String IP;
	Registry registro;
	//
	ArrayList<Avion> p = new ArrayList<Avion>();
	Queue<Avion> colaTurnos;
	
//agreado por lo de rmi	
	public Servidor (Integer numeroPuertoRemoto) throws Exception{
		super();
		IP = InetAddress.getLocalHost().getHostAddress();
		nroPuerto = numeroPuertoRemoto;
		registro = LocateRegistry.createRegistry(nroPuerto);
		registro.bind("rmiServidor", this);
		System.out.println("Servidor inicializado en ip: " + IP + "puerto: " + nroPuerto);
	}
//
	
	public Queue<Avion> asignarTurno(Avion avion) {
		colaTurnos.add(avion);	
		System.out.println("El avion se encuentra en la cola de espera de una pista");
		return colaTurnos;
		//este metodo lo agrega a la cola solamente, no indica ningun "turno" 	
	}

	public void atenderPeticion (Avion av) {
		//recibe solicitud de avion solicitando pista
		//verifica si hay pista disponible
		
		//Integer posicionPista =  posicionDisponiblePista();
		
		if ((p.size() >= 5)) {	
			asignarTurno(av); // si no esta disponible asigna turno, es decir agrega a la cola			
		}
		else {
			asignarPista(av);
			System.out.println("Se asigno la pista al avion");
			
		}	
		
	}

/*	public Integer posicionDisponiblePista() {
		//recorre el aray y devuelve la posicion que no este ocupada
		if (!(p.isEmpty())) {
			
			for (int i = 0; i < 5; i++) {
				if(p.get(i).equals(null)) {
					return i;
				}	
			}
			return -1;
			
		}
		else {
			return -1;
		*/

	public void asignarPista(Avion av) {
		// agrega el avion al array de pista , es decir queda estacionado
		p.add(av);
		//p.coleccionPista[posicion]= av;
		administraAterrizajes(av);

	}

	private void cuentaTiempoEstacionado() {
		//simulacion de los 30 segundos de aterrizaje y uso de la pista por parte del avion		
		Timer time = new Timer();
		TimerTask contador = new TimerTask() {
	
			public void run() {
				System.out.println("El avion esta aterrizando");
			}
		};	
		time.schedule(contador, 3000); //cuenta 30segundos y llama al run de contador	
		System.out.println("El avion esta por despegar");
	}
	
	public void administraAterrizajes(Avion av) {
		cuentaTiempoEstacionado(); // cuando llega a 30 llama a desasignarPista()
		desasignarPista(av);
		// tambien debe fijarse si hay alguien en la cola esperando 
		if (colaTurnos.isEmpty()) {
			System.out.println("Pista totalmente vacia");
		}
		else { 
			colaTurnos.remove();
			asignarPista(av); // y asigna ese avion a la pista
		}			
	}

	public void desasignarPista(Avion av){
		// saca el avion del aray de pista despues de 30 segundos
		p.remove(av);
		//p.coleccionPista[posicion]= null;	
	}

}
