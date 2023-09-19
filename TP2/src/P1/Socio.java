package P1;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;

public class Socio {
//    private int credencial;
    private TipoSuscripcion tipoSuscripcion; //Referencia de tipo conocimiento, es decir, estatica
    private String nombre;
    private String apellido;
    private String direccion;
    private String mail;
    private LocalDate fechaCreacion;

    public Socio(){
        this.tipoSuscripcion = null;
        this.nombre = null;
        this.apellido = null;
        this.direccion = null;
        this.mail = null;
    }

    public Socio(int credencial, TipoSuscripcion tipoSuscripcion, String nombre, String apellido, String direccion, String mail) {
//        this.credencial = credencial;
        this.tipoSuscripcion = tipoSuscripcion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.mail = mail;
    }

    //GETTERS

//    public int getCredencial() {
//        return credencial;
//    }

    public TipoSuscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMail() {
        return mail;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    //SETTERS

//    public void setCredencial(int credencial) {
//        this.credencial = credencial;
//    }

    public void setTipoSuscripcion(TipoSuscripcion tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTipoSuscripcion(String tipoSuscripcion){
        switch (tipoSuscripcion){
            case "basica":
                this.tipoSuscripcion = TipoSuscripcion.BASICA;
                break;
            case "intermedia":
                this.tipoSuscripcion = TipoSuscripcion.INTERMEDIA;
                break;
            case "destacada":
                this.tipoSuscripcion = TipoSuscripcion.DESTACADA;
        }
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    //METHODS
    public void createSocio(List<Socio> socios){
        Scanner escaner = new Scanner(System.in);
        Socio socio = new Socio();

        String nombre;
        System.out.print("Ingrese nombre del nuevo socio: ");
        nombre = escaner.nextLine();

        String apellido;
        System.out.print("\nIngrese apellido del nuevo socio: ");
        apellido = escaner.nextLine();

        String mail;
        System.out.print("\nIngrese mail del nuevo socio: ");
        mail = escaner.nextLine();

        String direccion;
        System.out.print("\nIngrese direccion del nuevo socio: ");
        direccion = escaner.nextLine();

        String tipoSocio;
        System.out.print("\nDigite tipo de suscripcion del nuevo socio (basica, intermedia, destacada): ");
        tipoSocio = escaner.nextLine();

        if(tipoSocio.equals("basica") || tipoSocio.equals("intermedia") || tipoSocio.equals("destacada")){
            socio.setNombre(nombre);
            socio.setApellido(apellido);
            socio.setMail(mail);
            socio.setDireccion(direccion);
            socio.setTipoSuscripcion(tipoSocio);
            socio.setFechaCreacion(LocalDate.now());
            socios.add(socio);
        } else{
            System.out.println("\nSuscripcion invalida, intente nuevamente.");
        }
    }

    public static void mostrarReporteMensual(List<Socio> listaSocios){
        System.out.println("Listado Socios Mensual");
        int j = 1;
        for(int i = 0; i < listaSocios.size(); i++){
            Socio socio = listaSocios.get(i);
            System.out.println("\nSocio " + j);
            if (socio.getFechaCreacion().getMonth().equals(LocalDate.now().getMonth()) && socio.getFechaCreacion().getYear() == LocalDate.now().getYear()) {
                System.out.println("Nombre: " + socio.getNombre());
                System.out.println("Apellido: " + socio.getApellido());
//                System.out.println("Credencial: " + socio.getCredencial());
                System.out.println("Tipo Suscripcion: " + socio.getTipoSuscripcion());
            }
        }
    }

    public static void mostrarSociosCalificados(List<Socio> listaSocios){
        List<Socio> listaBasica = new ArrayList<>();
        List<Socio> listaIntermedia = new ArrayList<>();
        List<Socio> listaDestacada = new ArrayList<>();

        for(int i = 0; i < listaSocios.size(); i++){
            Socio socio = listaSocios.get(i);
            if(socio.getTipoSuscripcion() == TipoSuscripcion.BASICA) listaBasica.add(socio);
            if(socio.getTipoSuscripcion() == TipoSuscripcion.INTERMEDIA) listaIntermedia.add(socio);
            if(socio.getTipoSuscripcion() == TipoSuscripcion.DESTACADA) listaDestacada.add(socio);
        }

        List<Socio> listaOrdenada = new ArrayList<>();
        listaOrdenada.addAll(listaDestacada);
        listaOrdenada.addAll(listaIntermedia);
        listaOrdenada.addAll(listaBasica);

        System.out.println("Lista socios ordenada por Suscripcion");
        for(int j = 0; j < listaOrdenada.size(); j++){
            Socio socio = listaOrdenada.get(j);
            System.out.println("\nNombre: " + socio.getNombre());
            System.out.println("Apellido: " + socio.getApellido());
//                System.out.println("Credencial: " + socio.getCredencial());
            System.out.println("Tipo Suscripcion: " + socio.getTipoSuscripcion());
        }
    }

}
