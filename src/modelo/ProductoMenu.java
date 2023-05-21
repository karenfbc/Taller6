package modelo;

public class ProductoMenu implements Producto {
	
	// atributos ProductoMenu
	
	private String nombre;
	
	private int precioBase;
	
	private int calorias;
	
	// constructor ProductoMenu

	public ProductoMenu(String nombre, int precioBase, int calorias) {
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.calorias = calorias;
	
	}
	
	// metodos ProductoMenu
	
	@Override
	public String getNombre() {
		return nombre;
		
	}
	
	@Override
	public int getPrecio() {
		return precioBase;
		
	}
	
	@Override
	public int getCalorias() {
		return calorias;
	}
	
	@Override
	public String generarTextoFactura() {
		
		String nombreFormateado = String.format("%-30.30s", nombre);
	    String precioBaseFormateado = String.format("%10d", precioBase);
	    return nombreFormateado + precioBaseFormateado;
		
	}

}
