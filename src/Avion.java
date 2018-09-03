import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Queue;

public class Avion implements TorreControl {

	//clase cliente
	//metodo a codificar: 
	//					solicitarPista()
	//					aterrizar(posicion, pista array de aviones) //
	private TorreControl rmiServidor;
	private Registry registro;
	private String direccionServidor;
	private Integer puertoServidor;
	
	public Avion(String ip, Integer puerto) throws RemoteException, NotBoundException{
		this.direccionServidor = ip; 
		this.puertoServidor = puerto;
		this.conectarseAlServidor();
	}
	
	public void conectarseAlServidor() throws RemoteException, NotBoundException{
		this.registro = LocateRegistry.getRegistry(this.direccionServidor, this.puertoServidor);
		this.rmiServidor = (TorreControl) registro.lookup("rmiServidor");
	}
	
	public void solicitarPista(Avion av) throws RemoteException{
		//llamado el método remoto
		rmiServidor.atenderPeticion(av);
		System.out.println("Solcitud enviada");
	}

	public void atenderPeticion(Avion av) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public Integer posicionDisponiblePista() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void asignarPista(Integer posicion, Avion av) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public Queue<Avion> asignarTurno(Avion avion) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void desasignarPista(Integer posicion, Avion av) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
