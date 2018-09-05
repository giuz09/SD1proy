import java.lang.reflect.Array;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.apache.xpath.internal.functions.Function;

import jdk.internal.org.objectweb.asm.commons.GeneratorAdapter;

public class mainCliente {
	public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
		final Avion A1 = new Avion("127.0.0.1", 2000,"A1");
		final Avion A2 = new Avion("127.0.0.1", 2000,"A2");
		final Avion A3 = new Avion("127.0.0.1", 2000,"A3");
		final Avion A4 = new Avion("127.0.0.1", 2000,"A4");
		final Avion A5 = new Avion("127.0.0.1", 2000,"A5");
		final Avion A6 = new Avion("127.0.0.1", 2000,"A6");
		
		
		
		A1.sleep(2000);
		A1.start();
		A2.sleep(3000);
		A2.start();
		A3.sleep(5000);
		A3.start();
		//A4.wait(generoAleatorio());
		A4.start();
		//A5.wait(generoAleatorio());
		A5.start();
		//A6.wait(generoAleatorio());
		A6.start();
		
			
		
	}

	private static Long generoAleatorio() {
		Random tiempoRandom = new Random ();
		return tiempoRandom.nextLong();
		
	}
	
}
