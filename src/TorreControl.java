import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public interface TorreControl {
		
	
	void atenderPeticion(Pista p, Avion av) throws RemoteException; 
	//metodo atender peticion de las aviones llama a verificar y asignar
	
	Integer posicionDisponiblePista(Pista p); 
	//retorna -1 si no esta disponible
	Integer asignarPista(Pista p, Integer posicion); 
	//devuelve la posicion donde aterrizar
	Queue <Avion> asignarTurno( Avion avion ); 
	//agregar a cola de turnos el avion
	Integer desasignarPista(Pista p, Integer posicion); 
	
	
	

	
	
}
