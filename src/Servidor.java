import java.rmi.RemoteException;
import java.util.Queue;
import java.util.Stack;
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

	public void atenderPeticion(Pista p, Avion av) {
		//recibe solicitud de avion solicitando pista
		//verifica si hay pista disponible
		
		Integer posicionPista =  posicionDisponiblePista(p);
		
		if ((posicionPista == -1)) {	
			asignarTurno(av); // si no esta disponible asigna turno, es decir agrega a la cola			
		}
		else {
			asignarPista(p,posicionPista,av);
			System.err.println("Se asigno la pista nro "+posicionPista);			
		}	
	}

	public Integer posicionDisponiblePista(Pista p) {
		//recorre el aray y devuelve la posicion que no este ocupada
		//este metodo dudo si va aca o en la clase pista ?�?�?�?�
		return null;
	}

	public void asignarPista(Pista p, Integer posicion, Avion av) {
		// agrega el avion al array de pista , es decir queda estacionado
		p.coleccionPista[posicion]= av;
		cuentaTiempoEstacionado();

	}

	private void cuentaTiempoEstacionado() {
		// Este metodo debe contar 30 segundos 
		// cuando llega a 30 llama a desasignarPista()
		// tambien debe fijarse si hay alguien en la cola esperando 
		// y asigna ese avion a la pista
		
	}

	public void desasignarPista(Pista p, Integer posicion, Avion av){
		// saca el avion del aray de pista despues de 30 segundos
		p.coleccionPista[posicion]= null;	
	}

}
