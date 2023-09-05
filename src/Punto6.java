import P6.Libro;

public class Punto6 {
    public static void main(String[] args) {
        Libro libro = new Libro("Las aventuras de pepe el challenger", "Pepe", 694, 10, 1);
        Libro libro2 = new Libro("Tato capo", "Tato", 88, 1, 1);

        System.out.println("\n\u001B[33mLIBRO 1\u001B[0m");
        libro.mostrarLibro();

        System.out.println("\n\u001B[33mLIBRO 2\u001B[0m");
        libro2.mostrarLibro();

        System.out.println("\nTEST Prestar libro 1");
        libro.prestarLibro();

        System.out.println("\nTEST Prestar libro 2");
        libro2.prestarLibro();

        System.out.println("\nCantidad total de prestamos: " + (libro.getEjemplaresPrestados() + libro2.getEjemplaresPrestados()));
    }
}
