package chatTorreControl;

    import java.io.*;  
    import java.net.*;
import java.util.Scanner;
import java.util.logging.*;  
    public class Servidor {  
       
    	private ServerSocket ss; 
    	private Socket socket;
    	private int idSession;
    	private DataOutputStream dos;  
        private DataInputStream dis; 
        
    	public Servidor()
    	{
    		
    		try {
				ss=new ServerSocket(10579);
				
				this.conectarServidor();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
			} 
    		
    	}
    	
    	public void conectarServidor() throws IOException
 
    	{
    		String mensaje = "";
    		 System.out.print("Inicializando servidor... "); 
    		 System.out.println("\t[OK]");  
             idSession = 0;  
             socket = ss.accept();
             dos = new DataOutputStream(socket.getOutputStream());  
             dis = new DataInputStream(socket.getInputStream());  
            
              
             System.out.println("Esperando recibir mensaje"); 
             while (true) {      
            	 Scanner sc = new Scanner (System.in);
            	 //lee mensaje
                 System.out.println("- Cliente dice "+dis.readUTF()); 
                 //escribe mensaje
                 mensaje = sc.nextLine();                 
                 dos.writeUTF(mensaje); 
                 System.out.println("- Enviado: " + mensaje);  
             }  
    		 
    	}
    	
    	
    	
    }  