package exceptions;

public class IngredienteRepetidoException extends HamburguesaException {

	 private String ingredienteRepetido;
	 
	 public IngredienteRepetidoException(String ingrediente) {
	        super("Hay un ingrediente repetido: " + ingrediente);
	        ingredienteRepetido = ingrediente;
	 }
	 
	 public String getIngredienteRepetido() {
	        return ingredienteRepetido;
	 }
	

}
