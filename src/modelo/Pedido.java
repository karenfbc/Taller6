package modelo;

import java.io.File;

public class Pedido {
	
	//atributos Pedido
	
	private int numeroPedidos;
	
	private int idPedido;
	
	private String nombreCliente;
	
	private String direccionCliente;
	
	//constructor Pedido	

	public Pedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;

	}
	
	//metodos Pedido	
	
	public int getIdPedido() {
		
	}
	
	public void agregarProducto(Producto nuevoItem) {
		
	}
	
	public void guardarFactura(File archivo) {
		
	}
	
	private int getPrecioNetoPedido() {
		
	}
	
	private int getPrecioTotalPedido() {
		
	}
	
	private int getPrecioIVAPedido() {
		
	}
	
	private String generarTextoFactura() {
		
	}
	
	
	
	

}
