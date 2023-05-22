package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Ingrediente;
import modelo.ProductoAjustado;
import modelo.ProductoMenu;

class ProductoAjustadoTest {

	@Test
	public void testAgregarIngrediente() {
		ProductoAjustado producto = new ProductoAjustado(new ProductoMenu("Hamburguesa", 100,500));
	    Ingrediente queso = new Ingrediente("Queso", 50, 25);

	    producto.agregarIngrediente(queso);

	    String expected = "Hamburguesa               100"
	            + "+ Queso               50";

	    assertEquals(expected, producto.generarTextoFactura());
	}

	@Test
	public void testQuitarIngrediente() {
		ProductoAjustado producto = new ProductoAjustado(new ProductoMenu("Hamburguesa", 100, 500));
	    Ingrediente tomate = new Ingrediente("Tomate", 25, 10);

	    producto.agregarIngrediente(tomate);
	    producto.quitarIngrediente(tomate);

	    String expected = "Hamburguesa               100"
	            + "+ Tomate               25"
	            + "- Tomate               0";
	    assertEquals(expected, producto.generarTextoFactura());
	}

	@Test
	public void testGetPrecio() {
		ProductoMenu base = new ProductoMenu("Hamburguesa", 100, 500);
		ProductoAjustado producto = new ProductoAjustado(base);
		Ingrediente ingrediente = new Ingrediente("Queso", 50, 100);
		producto.agregarIngrediente(ingrediente);
		assertEquals(150, producto.getPrecio());
	}

	@Test
	public void testGenerarTextoFactura() {
		ProductoMenu base = new ProductoMenu("Hamburguesa", 100, 500);
		ProductoAjustado producto = new ProductoAjustado(base);
		Ingrediente ingrediente1 = new Ingrediente("Queso", 50, 100);
		Ingrediente ingrediente2 = new Ingrediente("Tomate", 25, 50);
		producto.agregarIngrediente(ingrediente1);
		producto.agregarIngrediente(ingrediente2);
		assertEquals("Hamburguesa               100+ Queso               50+ Tomate               25", producto.generarTextoFactura());
	}

	@Test
	public void testGetCalorias() {
		ProductoMenu base = new ProductoMenu("Hamburguesa", 100, 500);
		ProductoAjustado producto = new ProductoAjustado(base);
		Ingrediente ingrediente = new Ingrediente("Queso", 50, 100);
		producto.agregarIngrediente(ingrediente);
		assertEquals(600, producto.getCalorias());
	}

}
