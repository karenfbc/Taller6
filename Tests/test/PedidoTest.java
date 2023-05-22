package test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import exceptions.PedidoExcepcion;
import modelo.Pedido;
import modelo.ProductoMenu;

class PedidoTest {

	@Test
    public void testAgregarProducto() {
        ProductoMenu producto1 = new ProductoMenu("Hamburguesa", 100, 200);
        ProductoMenu producto2 = new ProductoMenu("Bebida", 50, 100);

        Pedido pedido = new Pedido("Mario", "cra 58b");

        try {
            pedido.agregarProducto(producto1);
            pedido.agregarProducto(producto2);
        } catch (PedidoExcepcion e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertEquals(2, pedido.getListaProductos().size());
    }
	
	 @Test
	    public void testAgregarProductoExcedePrecio() {
	        ProductoMenu producto1 = new ProductoMenu("Hamburguesa", 100, 200);
	        ProductoMenu producto2 = new ProductoMenu("Bebida", 50, 100);

	        Pedido pedido = new Pedido("Mario", "cra 58b");

	        Assertions.assertThrows(PedidoExcepcion.class, () -> {
	            pedido.agregarProducto(producto1);
	            pedido.agregarProducto(producto2);
	            pedido.agregarProducto(producto2);
	        });
	        
	 }
	 
	 @Test
	    public void testGenerarTextoFactura() {
	        ProductoMenu producto1 = new ProductoMenu("Hamburguesa", 100, 200);
	        ProductoMenu producto2 = new ProductoMenu("Bebida", 50, 100);

	        Pedido pedido = new Pedido("Mario", "cra 58b");

	        try {
	            pedido.agregarProducto(producto1);
	            pedido.agregarProducto(producto2);
	        } catch (PedidoExcepcion e) {
	            fail("Exception thrown: " + e.getMessage());
	        }

	        String expectedFactura = "------ Factura ------\n" +
	                "ID del pedido: " + pedido.getIdPedido() + "\n" +
	                "Cliente: Mario\n" +
	                "Dirección de entrega: cra 58b\n" +
	                "----------------------\n" +
	                "Productos:\n" +
	                "Hamburguesa               200\n" +
	                "Bebida               100\n" +
	                "----------------------\n" +
	                "Total calorias: 300\n" +
	                "Precio neto: $150\n" +
	                "Impuesto IVA: $28\n" +
	                "Precio total: $178\n" +
	                "----------------------";

	        assertEquals(expectedFactura, pedido.generarTextoFactura());
	    }
	 
}