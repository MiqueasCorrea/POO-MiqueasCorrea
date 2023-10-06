package P8;
import Menu.Libro;
public class Libro extends Publicacion{
    private String isbn;
    private int numEjemplares;

    public Libro(String nombre, String editor, String telefonoProveedor, String isbn, int numEjemplares) {
        super(nombre, editor, telefonoProveedor);
        this.isbn = isbn;
        this.numEjemplares = numEjemplares;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }
}
