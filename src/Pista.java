import java.util.ArrayList;

public class Pista {
		
	Avion[] coleccionPista =new Avion[4];
	// vector que contiene las 5 pistas del aeropuerto

	
	public Integer posicionDisponible() {
		
		for (int i = 0; i < coleccionPista.length; i++) {
			Avion avion = coleccionPista[i];
			if (avion== null) {
				return i;
			}
		}
		return -1;
	}
	
	public Pista(Avion[] coleccionPista) {
		super();
		this.coleccionPista = coleccionPista;
	}
	public Avion[] getColeccionPista() {
		return coleccionPista;
	}
	public void setColeccionPista(Avion[] coleccionPista) {
		this.coleccionPista = coleccionPista;
	}
	
	
	
	
	

	
}
