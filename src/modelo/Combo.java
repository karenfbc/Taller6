package modelo;

import java.util.ArrayList;
import java.util.List;

public class Combo implements Producto{
	
	//atributos Combo
	
	private double descuento;
	
	private String nombreCombo;
	
	private int precio = 0;
	
	private int calorias = 0;
	
	
	
	//constructor Combo
	

	public Combo(String nombreCombo, int descuento) {
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
