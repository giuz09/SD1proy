import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public interface TorreControl extends Remote {
		
	
	void atenderPeticion(Avion av)throws RemoteException, InterruptedException;  //metodo atender peticion de las aviones llama a verificar y asignar
	
	//Integer posicionDisponiblePista()throws RemoteException; 	//retorna -1 si no esta disponible
	
	 void asignarPista( Avion av)throws RemoteException, InterruptedException; 
	 
	 void desasignarAvion( Avion av)throws RemoteException;

	
	
	//ArrayList <Avion> asignarTurno( Avion avion )throws RemoteException; //agregar a cola de turnos el avion
	
	
	
	
	

	
	
}
