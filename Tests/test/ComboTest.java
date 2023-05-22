package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import modelo.Combo;
import modelo.ProductoMenu;

class ComboTest {

	@Test
    public void testAgregarItemACombo() {
        ProductoMenu hamburguesa = new ProductoMenu("Hamburguesa", 100, 200);
        ProductoMenu bebida = new ProductoMenu("Bebida", 50, 100);

        Combo combo = new Combo("combo todoterreno", 10);
        combo.agregarItemACombo(hamburguesa);
        combo.agregarItemACombo(bebida);


        Assertions.assertEquals(135, combo.getPrecio());
    }

    @Test
    public void testGenerarTextoFactura() {
        Combo combo = new Combo("combo todoterreno", 10);


        Assertions.assertEquals("combo todoterreno"+ "               "+"0", combo.generarTextoFactura());
    }


    @Test
    public void testGetCalorias() {
        ProductoMenu hamburguesa = new ProductoMenu("Hamburguesa", 100, 200);
        ProductoMenu bebida = new ProductoMenu("Bebida", 50, 100);

        Combo combo = new Combo("combo todoterreno", 10);
        combo.agregarItemACombo(hamburguesa);
        combo.agregarItemACombo(bebida);

        Assertions.assertEquals(300, combo.getCalorias());
    }

}
