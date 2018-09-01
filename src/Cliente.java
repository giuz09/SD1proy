import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

	private TorreControl rmiServidor;
	private Registry registro;
	private String direccionServidor;
	private Integer puertoServidor;
	
	public Cliente(String ip, Integer puerto) throws RemoteException, NotBoundException{
		this.direccionServidor = ip; 
		this.puertoServidor = puerto;
		this.conectarseAlServidor();
	}
	
	public void conectarseAlServidor() throws RemoteException, NotBoundException{
		this.registro = LocateRegistry.getRegistry(this.direccionServidor, this.puertoServidor);
		this.rmiServidor = (TorreControl) registro.lookup("rmiServidor");
	}
}
