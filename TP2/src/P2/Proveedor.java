package P2;

import Menu.Menu;
import Menu.AnsiColorsitos;

import java.time.Year;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Proveedor {
    private String nombre;
    private TipoProveedor tipoProveedor;

    public Proveedor(){
        this(null);
    }
    public Proveedor(String nombre){
        this(nombre, null);
    }
    public Proveedor(String nombre, TipoProveedor tipoProveedor) {
        this.nombre = nombre;
        this.tipoProveedor = tipoProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoProveedor getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(TipoProveedor tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }

    //METHODS
    public void agregarProveedor(List<Proveedor> proveedores){
        System.out.println(AnsiColorsitos.YELLOW + "\n\n\tCrear Proveedor" + AnsiColorsitos.RESET);
        System.out.print(AnsiColorsitos.YELLOW + "Ingrese nombre del proveedor" + AnsiColorsitos.RESET + ": ");

        Scanner escaner = new Scanner(System.in);
        String nombre = escaner.nextLine();

        int respuesta = Menu.mostrarMenu("\nTipo de Proveedor", List.of("Transporte", "Hospedaje", "Excursion"));

        if(respuesta == 0){
            System.out.println(AnsiColorsitos.YELLOW + "Saliendo de la seccion creacion de proveedor..." + AnsiColorsitos.RESET);
            return;
        }
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(nombre);
        if (respuesta == 1){
            proveedor.setTipoProveedor(TipoProveedor.TRANSPORTE);
        }
        else if (respuesta == 2){
            proveedor.setTipoProveedor(TipoProveedor.HOSPEDAJE);
        }
        else if (respuesta == 3){
            proveedor.setTipoProveedor(TipoProveedor.EXCRUSION);
        }
        proveedores.add(proveedor);
        System.out.println(AnsiColorsitos.GREEN + "Proveedor creado con exito." + AnsiColorsitos.RESET);
    }

    public void mostrarProveedores(List<Proveedor> proveedores){
        if(proveedores.size() == 0){
            System.out.println(AnsiColorsitos.YELLOW + "No hay proveedores registrados." + AnsiColorsitos.RESET);
            return;
        }

        int i = 0;
        for(Proveedor proveedor : proveedores){
            i++;
            System.out.println(AnsiColorsitos.YELLOW + "\nProveedor " + i);
            System.out.println(AnsiColorsitos.YELLOW + "Nombre" + AnsiColorsitos.RESET + ": " + proveedor.getNombre());
            System.out.println(AnsiColorsitos.YELLOW + "Tipo de Proveedor" + AnsiColorsitos.RESET + ": " + proveedor.getTipoProveedor());
        }
    }

    public List<Proveedor> mostrarProveedoresTransporte(List<Proveedor> proveedores){
        List<Proveedor> proveedors_de_transporte = new ArrayList<>();
        int i = 0;
        for(Proveedor proveedor : proveedores){
            if(proveedor.getTipoProveedor() == TipoProveedor.TRANSPORTE){
                i++;
                System.out.println(AnsiColorsitos.YELLOW + "\nProveedor " + i);
                System.out.println(AnsiColorsitos.YELLOW + "Nombre" + AnsiColorsitos.RESET + ": " + proveedor.getNombre());
                System.out.println(AnsiColorsitos.YELLOW + "Tipo de Proveedor" + AnsiColorsitos.RESET + ": " + proveedor.getTipoProveedor());
                proveedors_de_transporte.add(proveedor);
            }
        }

        if(i == 0){
            System.out.println(AnsiColorsitos.YELLOW + "No hay proveedores de transporte vigentes.");
        }
        return proveedors_de_transporte;
    }

    public List<Proveedor> mostrarProveedoresHospedaje(List<Proveedor> proveedores){
        List<Proveedor> proveedors_de_hospedaje = new ArrayList<>();
        int i = 0;
        for(Proveedor proveedor : proveedores){
            if(proveedor.getTipoProveedor() == TipoProveedor.HOSPEDAJE){
                i++;
                System.out.println(AnsiColorsitos.YELLOW + "\nProveedor " + i);
                System.out.println(AnsiColorsitos.YELLOW + "Nombre" + AnsiColorsitos.RESET + ": " + proveedor.getNombre());
                System.out.println(AnsiColorsitos.YELLOW + "Tipo de Proveedor" + AnsiColorsitos.RESET + ": " + proveedor.getTipoProveedor());
                proveedors_de_hospedaje.add(proveedor);
            }
        }

        if(i == 0){
            System.out.println(AnsiColorsitos.YELLOW + "No hay proveedores de Hospedaje vigentes.");
        }
        return proveedors_de_hospedaje;
    }

    public List<Proveedor> mostrarProveedoresExcursion(List<Proveedor> proveedores){
        List<Proveedor> proveedors_de_excursion = new ArrayList<>();
        int i = 0;
        for(Proveedor proveedor : proveedores){
            if(proveedor.getTipoProveedor() == TipoProveedor.EXCRUSION){
                i++;
                System.out.println(AnsiColorsitos.YELLOW + "\nProveedor " + i);
                System.out.println(AnsiColorsitos.YELLOW + "Nombre" + AnsiColorsitos.RESET + ": " + proveedor.getNombre());
                System.out.println(AnsiColorsitos.YELLOW + "Tipo de Proveedor" + AnsiColorsitos.RESET + ": " + proveedor.getTipoProveedor());
                proveedors_de_excursion.add(proveedor);
            }
        }
        if(i == 0){
            System.out.println(AnsiColorsitos.YELLOW + "No hay proveedores de Excursion vigentes.");
        }
        return proveedors_de_excursion;
    }
}
