import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class mainCliente {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Cliente c = new Cliente("192.168.237.229", 2000);
	
	}

}
