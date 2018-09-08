import java.io.IOException;
import java.lang.reflect.Array;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.sun.org.apache.xpath.internal.functions.Function;

import jdk.internal.org.objectweb.asm.commons.GeneratorAdapter;


public class mainCliente {
	public static void main(String[] args) throws NotBoundException, InterruptedException, UnknownHostException, IOException {
		final Avion A1 = new Avion("127.0.0.1", 2000,"A1");
		final Avion A2 = new Avion("127.0.0.1", 2000,"A2");
		final Avion A3 = new Avion("127.0.0.1", 2000,"A3");
		final Avion A4 = new Avion("127.0.0.1", 2000,"A4");
		final Avion A5 = new Avion("127.0.0.1", 2000,"A5");
		final Avion A6 = new Avion("127.0.0.1", 2000,"A6");
		final Avion A7 = new Avion("127.0.0.1", 2000,"A7");
		final Avion A8 = new Avion("127.0.0.1", 2000,"A8");
		final Avion A9 = new Avion("127.0.0.1", 2000,"A9");
		final Avion A10 = new Avion("127.0.0.1", 2000,"A10");
		
		A1.start();A2.start();
		A3.start();A4.start();
		A5.start();A6.start();
		A7.start();A8.start();
		A9.start();A10.start();
		
		ClienteComunicacion cs = new ClienteComunicacion();
		

 /*	
  	final ArrayList<Avion> lanzador = new ArrayList<Avion>();
		lanzador.add(A1);lanzador.add(A2);
		lanzador.add(A3);lanzador.add(A4);
		lanzador.add(A5);lanzador.add(A6);
		lanzador.add(A7);lanzador.add(A8);
		lanzador.add(A9);lanzador.add(A10);	
			
		final Integer i = 0;
		Timer timer= new Timer();
		
		TimerTask tarea = new TimerTask() 
	    { 
	        public void run()  
	        { 
	    			lanzador.get(i).start();
	    			
	        } 
	    };
	    while (i<=9) {
	    	Long numero = (long) ((Math.random() * 10000) + 1);
	  	    timer.schedule(tarea, numero);	  				
		}
		*/
	}
	
	

		
}
