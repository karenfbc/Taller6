package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.ProductoMenu;

class ProductoMenuTest {

	@Test
	public void testGenerarTextoFactura() {
		ProductoMenu producto = new ProductoMenu("Hamburguesa", 100, 500);
		String textoFactura = producto.generarTextoFactura();
		assertEquals("Hamburguesa                        100", textoFactura);
	}
}
