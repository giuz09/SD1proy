import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class mainCliente {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Avion c = new Avion("127.0.0.1", 2000);
	
	}

}
