package modelo;

public class Combo implements Producto{
	
	//atributos Combo
	
	private double descuento;
	
	private String nombreCombo;
	
	
	//constructor Combo
	

	public Combo(String nombreCombo, double descuento) {
		this.nombreCombo = nombreCombo;
		this.descuento = descuento;
		
	}
	
	//metodos Combo
	
	public void agregarItemACombo(Producto itemCombo) {
		
	}
	
	@Override
	public int getPrecio() {
		
		return precio * descuento / 100;
	}
	
	public String generarTextoFactura() {
		
	}
	
	public String getNombre() {
		return nombreCombo;
		
	}
}
