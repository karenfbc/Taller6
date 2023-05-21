package exceptions;

public class ProductoRepetidoException extends HamburguesaException {
    private String productoRepetido;

    public ProductoRepetidoException(String producto) {
        super("Hay un producto repetido: " + producto);
        productoRepetido = producto;
    }

    public String getProductoRepetido() {
        return productoRepetido;
    }
    
}
