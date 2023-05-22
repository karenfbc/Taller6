package consola;

import java.io.File;
import java.util.Scanner;

import modelo.Restaurante;

public class Aplicacion {
	
	
	// metodos Aplicacion
	
	public void mostrarMenu() {
		
		System.out.println("1. Mostrar el menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un nuevo elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido por Id");
		System.out.println("6. Salir de la aplicación");
		
	}
	
	public void ejecutarOpcion(int opcionSeleccionada) {
		boolean continuar = true;
		while(continuar) {
			try {
				mostrarMenu();
				Scanner scanner = new Scanner(System.in);
				int opcion = scanner.nextInt();
				
				if(opcion == 1) {
					System.out.println("------ Menú ------");
					System.out.println("------------------");
					
				}
				
				else if(opcion == 2){
					iniciarNuevoPedido();
				}
				}
				
			}
				
				
	}
	
	private void iniciarNuevoPedido() 
	{	
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
