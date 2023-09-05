package P6;

public class Libro {
    private String titulo;
    private String autor;
    private int numPaginas;
    private int quedanEjemplares;
    private int ejemplaresPrestados;

    public Libro(String titulo, String autor, int numPaginas, int quedanEjemplares, int ejemplaresPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.quedanEjemplares = quedanEjemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
    }


    //GETTERS
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public int getQuedanEjemplares() {
        return quedanEjemplares;
    }

    public int getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    //SETERS

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setQuedanEjemplares(int quedanEjemplares) {
        this.quedanEjemplares -= quedanEjemplares;
    }

    public void setEjemplaresPrestados(int ejemplaresPrestados) {
        this.ejemplaresPrestados += ejemplaresPrestados;
    }


    //METODOS
    public void mostrarLibro(){
        System.out.println("El libro " + getTitulo() +
                           "\nCreado por el autor " + getAutor() +
                           "\nTiene " + getNumPaginas() + " paginas" +
                           "\nY quedan " + getQuedanEjemplares() + " ejemplares" +
                           "\nSe prestaron " + getEjemplaresPrestados() + " ejemplares");
    }

    public void prestarLibro(){
        if(getQuedanEjemplares() == 1){
            System.out.println("El libro " + getTitulo() + " no puede ser prestado ya que es la ultima unidad.\n");
        } else{
            this.setEjemplaresPrestados(1);
            this.setQuedanEjemplares(1);
            System.out.println("Libro " + getTitulo() + " prestado correctamente!\n");
        }
    }

}
