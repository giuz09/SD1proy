package chatTorreControl;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteSimple {
	
	protected Socket sk;  
    protected DataOutputStream dos;  
    protected DataInputStream dis;  
   
    
    public ClienteSimple() throws UnknownHostException, IOException {  
    	this.setSk(new Socket("127.0.0.1", 10579)); 
        this.setDos(new DataOutputStream(this.getSk().getOutputStream()));  
        this.setDis(new DataInputStream(this.getSk().getInputStream())); 
        enviarDatos();
    }  
    
    
    public void enviarDatos()
    {
    	 try {        
             String respuesta="";             
             String mensaje = ""; 
             System.out.println("A la espera de su mensaje"); 
             System.out.println("para finalizar la comunicacion ingrese: finalizar "); 
             while (!mensaje.equalsIgnoreCase("stop")) {                   
            	 Scanner sc = new Scanner (System.in);
                 mensaje = sc.nextLine(); 
                 
                 //escribe mensaje
                 this.getDos().writeUTF(mensaje); 
                 System.out.println("- Enviado: " + mensaje);  
                 //lee mensaje
                 respuesta = this.getDis().readUTF();            
                 System.out.println(" Servidor dice: " + respuesta);  
             			} 
             	 this.getDis().close();  
             this.getDos().close();  
             this.getSk().close();
               
         } catch (IOException ex) {  
             Logger.getLogger(ClienteSimple.class.getName()).log(Level.SEVERE, null, ex);  
         } 

    }
   
	
	public Socket getSk() {
		return sk;
	}
	public void setSk(Socket sk) {
		this.sk = sk;
	}
	public DataOutputStream getDos() {
		return dos;
	}
	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}
	public DataInputStream getDis() {
		return dis;
	}
	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}

}
