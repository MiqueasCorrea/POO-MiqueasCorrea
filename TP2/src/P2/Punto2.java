package P2;

import Menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;

public class Punto2 {
    public static void main(String[] args){
        List<Paquete> paquetesVigentes = new ArrayList<>();
        List<Cliente> clientesVigentes = new ArrayList<>();
        List<Proveedor> proveedoresVigentes = new ArrayList<>();
        List<Proveedor> ventas = new ArrayList<>();

        Paquete paquete = new Paquete();
        Proveedor proveedor = new Proveedor();
        int respuesta;
        do {
            respuesta = Menu.mostrarMenu("\n\n\tAgencia de Turismo", List.of("Agregar paquete de turismo.", "Mostrar paquetes de turismo vigentes.", "Agregar proveedor.", "Mostrar proveedores.", "Vender paquete de turismo (agregar cliente).", "Mostrar clientes."));
            if (respuesta == 1) {
                paquete.agregarPaquete(paquetesVigentes, proveedoresVigentes);
            }
            if (respuesta == 2){
                paquete.mostrarPaquetes(paquetesVigentes);
            }
            else if (respuesta == 3){
                proveedor.agregarProveedor(proveedoresVigentes);
            }
            else if (respuesta == 4){
                proveedor.mostrarProveedores(proveedoresVigentes);
            }
        } while(respuesta != 0);
    }
}