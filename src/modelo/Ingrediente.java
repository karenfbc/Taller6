package modelo;

public class Ingrediente {
	
	// atributos Ingrediente
	
	private String nombre;
	
	private int costoAdicional;
	
	private int calorias;
	
	// constructor Ingrediente

	public Ingrediente(String nombre, int costoAdicional, int calorias) {
		 this.nombre = nombre;
	     this.costoAdicional = costoAdicional;
	     this.calorias = calorias;
		
	}
	
	// metodos Ingrediente
	
	public String getNombre(){
		return nombre;
		
	}
	
	public int getCostoAdicional() {
		return costoAdicional;
		
	}
	
	public int getCalorias() {
		return calorias;
	}
	

}
