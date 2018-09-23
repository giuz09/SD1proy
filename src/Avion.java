import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class Avion extends Thread implements TorreControl, Serializable  {
	
	private String codigoAvion;

	
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
	
	public void solicitarPista() throws RemoteException, InterruptedException{
		//llamado el método remoto
		rmiServidor.atenderPeticion(this);
	}

	public void atenderPeticion(Avion av) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void asignarPista(Avion av) throws RemoteException, InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public void desasignarAvion(Avion av) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	

	public void run() {
		
		// TODO Auto-generated method stub
	
			try {
				sleep((long) ((Math.random() *50000) + 1));
				solicitarPista();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}



	



}