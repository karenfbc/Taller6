package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptions.PedidoExcepcion;

public class Pedido {
	
	//atributos Pedido
	
	private int numeroPedidos;
	
	private int idPedido;
	
	private String nombreCliente;
	
	private String direccionCliente;
	
	private List<Producto> listaProductos;
	
	private static int contadorPedidos = 0;
	
	//constructor Pedido	

	public Pedido(String nombreCliente, String direccionCliente) {
		this.idPedido = ++contadorPedidos;
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.listaProductos = new ArrayList<>();

	}
	
	//metodos Pedido	
	
	public int getIdPedido() {
		return idPedido;
		
	}
	
	public void agregarProducto(Producto nuevoItem) throws PedidoExcepcion {
		
		int precioTotal = getPrecioTotalPedido() + nuevoItem.getPrecio();
	    if (precioTotal > 150000) {
	        throw new PedidoExcepcion("No se puede agregar el producto. El valor total del pedido supera los 150.000 pesos.");
	    }
		listaProductos.add(nuevoItem);
	}
	
	public void guardarFactura(File archivo) {
		
		try {
			FileWriter writer = new FileWriter(archivo);
			writer.write(generarTextoFactura());
			writer.close();
			System.out.println("Factura guardada correctamente.");
		} catch (IOException e) {
			System.out.println("Error al guardar la factura: " + e.getMessage());
		}
	}
		
	
	private int getCaloriasPedido() {
		int calorias = 0;
		for (Producto producto : listaProductos) {
			calorias += producto.getCalorias();
		}
		return calorias;
		
	}
	
	private int getPrecioNetoPedido() {
		int precioNeto = 0;
		for (Producto producto : listaProductos) {
			precioNeto += producto.getPrecio();
		}
		return precioNeto;
		
	}
	
	private int getPrecioIVAPedido() {
		int precioNeto = getPrecioNetoPedido();
		return (int) (precioNeto * 0.19);
		
	}
	
	private int getPrecioTotalPedido() {
		
		int precioNeto = getPrecioNetoPedido();
		int precioIVA = getPrecioIVAPedido();
		return precioNeto + precioIVA;
		
	}
	
	
	private String generarTextoFactura() {
		
		StringBuilder factura = new StringBuilder();
		factura.append("------ Factura ------\n");
		factura.append("ID del pedido: ").append(idPedido).append("\n");
		factura.append("Cliente: ").append(nombreCliente).append("\n");
		factura.append("Dirección de entrega: ").append(direccionCliente).append("\n");
		factura.append("----------------------\n");
		factura.append("Productos:\n");
		for (Producto producto : listaProductos) {
			factura.append(producto.generarTextoFactura()).append("\n");
		}
		factura.append("----------------------\n");
		factura.append("Total calorias: ").append(getCaloriasPedido()).append("\n");
		factura.append("Precio neto: $").append(getPrecioNetoPedido()).append("\n");
		factura.append("Impuesto IVA: $").append(getPrecioIVAPedido()).append("\n");
		factura.append("Precio total: $").append(getPrecioTotalPedido()).append("\n");
		factura.append("----------------------");
		return factura.toString();
	}
		
	
	}
	
	
	
	

