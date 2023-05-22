package test;
import static org.junit.jupiter.api.Assertions.*;

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
		 Pedido pedido = new Pedido();
	        Producto producto = new Producto("Producto", 200000);
	        
	        PedidoExcepcion exception = Assertions.assertThrows(PedidoExcepcion.class, () -> pedido.agregarProducto(producto));

	        
	        String expectedMessage = "No se puede agregar el producto. El valor total del pedido supera los 150.000 pesos.";
	        String actualMessage = exception.getMessage();
	        Assertions.assertEquals(expectedMessage, actualMessage);
	    }

}
