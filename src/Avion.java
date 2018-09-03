import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Queue;

public class Avion implements TorreControl, Serializable {
	
	private String codigoAvion;

	//clase cliente
	//metodo a codificar: 
	//					solicitarPista()
	//					aterrizar(posicion, pista array de aviones) //
	private TorreControl rmiServidor;
	private Registry registro;
	private String direccionServidor;
	private Integer puertoServidor;
	
	public String getCodigoAvion() {
		return codigoAvion;
	}

	public void setCodigoAvion(String codigoAvion) {
		this.codigoAvion = codigoAvion;
	}

	public Avion(String ip, Integer puerto, String codigoAvion) throws RemoteException, NotBoundException{
		this.direccionServidor = ip; 
		this.puertoServidor = puerto;
		this.conectarseAlServidor();
		this.codigoAvion= codigoAvion;
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

	public void asignarPista(Avion av) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Avion> asignarTurno(Avion avion) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void desasignarPista(Avion av) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}