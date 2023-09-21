package P2;
import Menu.Menu;
import Menu.AnsiColorsitos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paquete {
    private String destino;
    private Proveedor proovedor_de_transporte;
    private Proveedor proovedor_de_hospedaje;
    private List<Proveedor> proovedor_de_excursion;

    public Paquete(){
        this(null);
    }
    public Paquete(String destino){
        this(destino, null);
    }

    public Paquete(String destino, Proveedor proovedor_de_transporte){
        this(destino, proovedor_de_transporte, null);
    }

    public Paquete(String destino, Proveedor proovedor_de_transporte, Proveedor proovedor_de_hospedaje){
        this(destino, proovedor_de_transporte, proovedor_de_hospedaje, null);
    }
    public Paquete(String destino, Proveedor proovedor_de_transporte, Proveedor proovedor_de_hospedaje, List<Proveedor> proovedor_de_excursion) {
        this.destino = destino;
        this.proovedor_de_transporte = proovedor_de_transporte;
        this.proovedor_de_hospedaje = proovedor_de_hospedaje;
        this.proovedor_de_excursion = new ArrayList<>();
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Proveedor getProovedor_de_transporte() {
        return proovedor_de_transporte;
    }

    public void setProovedor_de_transporte(Proveedor proovedor_de_transporte) {
        this.proovedor_de_transporte = proovedor_de_transporte;
    }

    public Proveedor getProovedor_de_hospedaje() {
        return proovedor_de_hospedaje;
    }

    public void setProovedor_de_hospedaje(Proveedor proovedor_de_hospedaje) {
        this.proovedor_de_hospedaje = proovedor_de_hospedaje;
    }

    public List<Proveedor> getProovedor_de_excursion() {
        return proovedor_de_excursion;
    }

    public void setProovedor_de_excursion(List<Proveedor> proovedor_de_excursion) {
        this.proovedor_de_excursion = proovedor_de_excursion;
    }

    //METHODS
    public void agregarPaquete(List<Paquete> paquetesVigentes, List<Proveedor> proveedores){
        System.out.println(AnsiColorsitos.YELLOW + "\n\n\tCrear Paquete" + AnsiColorsitos.RESET);
        System.out.print(AnsiColorsitos.YELLOW + "Ingrese destino" + AnsiColorsitos.RESET + ": ");
        Scanner escaner = new Scanner(System.in);
        String destino = escaner.nextLine();


        int respuesta = Menu.mostrarMenu("\nVerificar proveedores vigentes.", List.of("Transporte", "Hospedaje", "Excursion"));

        if (respuesta == 0){
            System.out.println(AnsiColorsitos.YELLOW + "Saliendo de la seccion creacion de proveedor..." + AnsiColorsitos.RESET);
            return;
        }

        Proveedor aux = new Proveedor();
        boolean empty = false;
        if (respuesta == 1){
            List<Proveedor> proveedores_Transporte = aux.mostrarProveedoresTransporte(proveedores);
            if(proveedores_Transporte.size() == 0) empty = true;
        }
        else if (respuesta == 2){
            List<Proveedor> proveedores_Hospedaje = aux.mostrarProveedoresHospedaje(proveedores);
            if(proveedores_Hospedaje.size() == 0) empty = true;
        }
        else if (respuesta == 3){
            List<Proveedor> proveedores_Excursion = aux.mostrarProveedoresExcursion(proveedores);
            if(proveedores_Excursion.size() == 0) empty = true;
        }

        if(empty){
            System.out.println(AnsiColorsitos.YELLOW + "No hay proveedores de esa clasificacion.");
            return;
        }
        System.out.print(AnsiColorsitos.YELLOW + "Digite el numero del proveedor" + AnsiColorsitos.RESET + ": ");
        





    }
}