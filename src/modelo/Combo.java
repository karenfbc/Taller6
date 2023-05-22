package modelo;

public class Combo implements Producto{
	
	//atributos Combo
	
	private double descuento;
	
	private String nombreCombo;
	
	private int precio = 0;
	
	private int calorias = 0;
	
	
	//constructor Combo
	

	public Combo(String nombreCombo, double descuento) {
		this.nombreCombo = nombreCombo;
		this.descuento = descuento;
		
	}
	
	//metodos Combo
	
	public void agregarItemACombo(Producto itemCombo) {
		
		precio += itemCombo.getPrecio();
		calorias += itemCombo.getCalorias();
		
	}
	
	@Override
	public int getPrecio() {
		
		return (int) (precio * descuento / 100);
	}
	
	@Override
	public String generarTextoFactura() {
		
		String nombreFormateado = String.format("%-30.30s", nombreCombo);
	    String precioBaseFormateado = String.format("%10d", precio);
	    return nombreFormateado + precioBaseFormateado;
		
	}
	
	@Override
	public String getNombre() {
		return nombreCombo;
		
	}

	@Override
	public int getCalorias() {
		return calorias;
	}
}
