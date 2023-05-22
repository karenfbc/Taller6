package modelo;

public class ProductoAjustado implements Producto {
	
	//atributos ProductoBase
	
	private ProductoMenu base;
	private int precio = 0;
	private int calorias = 0;
	private String factura = "";
	
	// constructor ProductoAjustado

	public ProductoAjustado(ProductoMenu base) {
		this.base = base;
		
	}
	
	// metodos ProductoAjustado
	
			//agregar y quitar ingredientes de producto
	
	public void agregarIngrediente(Ingrediente ingrediente) {
		
		precio += ingrediente.getCostoAdicional();
        calorias += ingrediente.getCalorias();

        String nombreIngredienteFormateado = ingrediente.getNombre();
        String precioIngredienteFormateado = String.valueOf(ingrediente.getCostoAdicional());
        factura += "+ " + nombreIngredienteFormateado + "               " + precioIngredienteFormateado;
    
	}
		
	
	public void quitarIngrediente(Ingrediente ingrediente) {
		
		calorias -= ingrediente.getCalorias();

        String nombreIngredienteFormateado = ingrediente.getNombre();
        String precioIngredienteFormateado = "0";
        factura += "- " + nombreIngredienteFormateado + "               " + precioIngredienteFormateado;
        
	}
	
	        //
	
	@Override
	public String getNombre() {
		return base.getNombre() ;
		
	}
	
	@Override
	public int getPrecio() {
		return base.getPrecio() + precio;
		
	}
	
	@Override
	public String generarTextoFactura() {
		return base.generarTextoFactura() + factura;
	}

	@Override
	public int getCalorias() {
		return base.getCalorias() + calorias;
	}

}
