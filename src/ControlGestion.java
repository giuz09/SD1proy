import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Stack;

public interface ControlGestion {
	
	
	////metodo a codificar: 
	//					verificarDisponiblePista(
	//					asignarPista()
	//					desasignarPista()
	//					asignarTurno()
	
	boolean verificarDisponiblePista(boolean array[]) throws RemoteException;
	Integer asignarPista(boolean array[]) throws RemoteException;
	Integer desasignarPista(boolean array[]) throws RemoteException;
	Stack<Boolean> asignarTurno() throws RemoteException;
	

	
	
}
