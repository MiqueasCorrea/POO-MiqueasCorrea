package P1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Punto1 {
    public static void main(String[] args) {
        List<Socio> listaSocios = new ArrayList<>();
        Socio socio = new Socio();
        int respuesta;
        do {
            Scanner escaner = new Scanner(System.in);
            respuesta = 0;

            mostrarMenu();

            try {
                respuesta = escaner.nextInt();
            } catch (Exception e) {
                System.out.println("Error en la respuesta.");
            }

            switch (respuesta){
                case 1:
                    socio.createSocio(listaSocios);
                    break;
                case 2:
                    Socio.mostrarReporteMensual(listaSocios);
                    break;
                case 3:
                    TipoSuscripcion.getActividades();
                    break;
                case 4:
                    Socio.mostrarSociosCalificados(listaSocios);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.\n");
            }

        } while (respuesta != 5);
    }

    public static void mostrarMenu(){
        System.out.print("\n\n\tMENU\n" +
                         "1. Crear nuevo socio.\n" +
                         "2. Reporte mensual de nuevos socios inscriptos.\n" +
                         "3. Listado de actividades (clasificadas por suscripcion).\n" +
                         "4. Listado de socios clasificados por suscripcion adquirida.\n" +
                         "5. Salir.\n" +
                         "Ingrese una opcion: ");
    }
}
