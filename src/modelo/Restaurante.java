package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exceptions.IngredienteRepetidoException;
import exceptions.ProductoRepetidoException;

public class Restaurante {

	// atributos Restaurante

	private ArrayList<Producto> menuLista = new ArrayList<>();

	private ArrayList<Ingrediente> ingredientesLista = new ArrayList<>();
	

	// constructor Restaurante

	public Restaurante() {
	}

	// metodos Restaurante

	public void iniciarPedido(String nombreCliente, String direccionCliente) {

	}

	public void cerrarYGuardarPedido() {

	}

	public Pedido getPedidoEnCurso() {

	}

	public ArrayList<Producto> getMenuBase() {
		return (ArrayList<Producto>) menuLista;
	}


	public ArrayList<Ingrediente> getIngredientes() {
		return (ArrayList<Ingrediente>) ingredientesLista;
	}


	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos, File archivoBebidas) {

		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		cargarBebidas(archivoBebidas);
	}

	private void cargarBebidas(File archivoBebidas) {
		
		
	}

	private void cargarIngredientes(File archivoIngredientes) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(archivoIngredientes));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(";");
				if (parts.length == 3) {
					String nombre = parts[0].trim();
					int precio = Integer.parseInt(parts[1].trim());
					int calorias = Integer.parseInt(parts[2].trim());
					Ingrediente ingrediente = new Ingrediente(nombre, precio, calorias);
					
					if (ingredientesLista.contains(ingrediente)) {
	                    throw new IngredienteRepetidoException(nombre);
	                }

	                ingredientesLista.add(ingrediente);

				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IngredienteRepetidoException e) {
	        System.out.println(e.getMessage());
	    }

		for (Ingrediente ingrediente : ingredientesLista) {
			String nombre = ingrediente.getNombre();
			int precio = ingrediente.getCostoAdicional();
			System.out.println(nombre + "-" + String.valueOf(precio));
		}

	}

	private void cargarMenu(File archivoMenu) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(archivoMenu));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(";");
				if (parts.length == 3) {
					String item = parts[0].trim();
					int precio = Integer.parseInt(parts[1].trim());
					int calorias = Integer.parseInt(parts[2].trim());
					Producto producto = new ProductoMenu(item, precio, calorias);
					
					 if (menuLista.contains(producto)) {
		                    throw new ProductoRepetidoException(item);
		                }

		                menuLista.add(producto);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ProductoRepetidoException e) {
	        System.out.println(e.getMessage());
	    }

		for (Producto producto : menuLista) {
			String nombre = producto.getNombre();
			int precio = producto.getPrecio();
			System.out.println(nombre + "-" + String.valueOf(precio));
		}

	}

	private void cargarCombos(File archivoCombos) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(archivoCombos));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] combos = line.split(";");
				
				if (combos.length == 5) {
				String nombre = combos[0].trim();
				int descuento = Integer.parseInt(combos[1].trim().replace("%", ""));
				
				// agregar precio y calorias individuales a items del combo 
				
				
				String hamburguesa = combos[2].trim();;
				String acompanamiento =combos[3].trim();;
				String bebida = combos[4].trim(); ;
				
				
				Combo combo = new Combo(nombre, descuento);
				Producto producto = combo;
				menuLista.add(producto);
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
