package consola;

import java.io.File;

import modelo.Restaurante;

public class Aplicacion {
	
	
	// metodos Aplicacion
	
	public void mostrarMenu() {
		
	}
	
	public void ejecutarOpcion(int opcionSeleccionada) {
		
	}

	public static void main(String[] args) {
		
		File archivoIngredientes = new File("data/ingredientes.txt");
		File archivoMenu = new File("data/menu.txt");
		File archivoCombos = new File("data/combos.txt");
		File archivoBebidas = new File("data/bebidas.txt");
		
		
		Restaurante res = new Restaurante();
		res.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos, archivoBebidas);

	}

}
