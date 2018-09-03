import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Avion {

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
	
	public void solicitarPista(Pista p, Avion av) throws RemoteException{
		//llamado el m�todo remoto
		rmiServidor.atenderPeticion(p, av);
		System.out.println("Solcitud enviada");
	}
}
