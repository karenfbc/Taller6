package modelo;

public class Combo implements Producto{
	
	//atributos Combo
	
	private double descuento;
	
	private String nombreCombo;
	
	private int precio;
	
	private int calorias;
	
	
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
		
		return (int) (precio * descuento / 100);
	}
	
	public String generarTextoFactura() {
		
	}
	
	public String getNombre() {
		return nombreCombo;
		
	}
}
