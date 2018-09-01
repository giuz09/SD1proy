import java.rmi.RemoteException;
import java.util.Queue;
import java.util.Stack;

public class Servidor implements TorreControl {
	
	Queue<Avion> colaTurnos;

	
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
			asignarPista(p,posicionPista);
			System.err.println("Se asigno la pista nro "+posicionPista);			
		}	
	}

	public Integer posicionDisponiblePista(Pista p) {
		//recorre el aray y devuelve la posicion que no este ocupada
		return null;
	}

	public Integer asignarPista(Pista p, Integer posicion) {
		// agrega el avion al array de pista , es decir queda estacionado
		
		return null;
	}

	public Integer desasignarPista(Pista p, Integer posicion){
		// saca el avion del aray de pista 
		return null;
	}

}
