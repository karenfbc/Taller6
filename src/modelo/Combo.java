package modelo;

import java.util.ArrayList;
import java.util.List;

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
		this.precio = 0;
		this.calorias = 0;
	}
	
	//metodos Combo
	
	public void agregarItemACombo(Producto itemCombo) {
		
		precio += itemCombo.getPrecio();
		calorias += itemCombo.getCalorias();
		
	}
	
	@Override
	public int getPrecio() {
		return (int) (precio * (1-descuento));
	}
	
	@Override
	public String generarTextoFactura() {
		
		String nombreFormateado = nombreCombo;
	    String precioBaseFormateado = String.valueOf(calorias);
	    return nombreFormateado + "               "+ precioBaseFormateado;
		
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
