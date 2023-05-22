package test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import modelo.ProductoMenu;


class ProductoMenuTest {
    @Test
    public void testGenerarTextoFactura() {
        ProductoMenu producto = new ProductoMenu("papas medianas", 100, 500);
        String textoFactura = producto.generarTextoFactura();
        assertEquals("papas medianas               100", textoFactura);
    }
}

