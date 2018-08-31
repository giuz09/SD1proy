import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Stack;

public interface TorreControl {
	
	
	////metodo a codificar: 
	//					verificarDisponiblePista(
	//					asignarPista()
	//					desasignarPista()
	//					asignarTurno()
	
	
	void atenderPeticion();
	//metodo atender peticion de las aviones llama a verificar y asignar
	Integer posicionDisponiblePista(Avion array[]) throws RemoteException; //retorna -1 si no esta disponible
	Integer asignarPista(Avion array[], Integer posicion) throws RemoteException; //devuelve la posicion donde aterrizar
	Stack <Avion> asignarTurno(Stack<Avion>, Avion avion ) throws RemoteException; //agregar a cola de turnos el avion
	
	
	
	Integer desasignarPista(boolean array[]) throws RemoteException; /// hablar con giuli
	
	

	
	
}
