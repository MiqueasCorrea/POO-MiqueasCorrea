package P13;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import P13.Tarea;

public class Punto13 {
    public static void main(String[] args) {
        List<Tarea> tareas = new ArrayList<>();
        Tarea tareita = new Tarea();
        boolean fin = false;
        do {
            Scanner respuestaScanner = new Scanner(System.in);
            int respuesta = 0;
            mostrarMenu();
            respuesta = respuestaScanner.nextInt();
            switch (respuesta){
                case 1:
                    tareita.nuevaTarea(tareas);
                    break;
                case 2:
                    tareita.mostrarTareas(tareas);
                    break;
                case 3:
                    tareita.modificarTareas(tareas);
                    break;
//                case 4:
//                    tareita.verificarEstadoTareas(tareas);
//                    break;
                case 4:
                    tareita.mostrarTareasColaboradores(tareas);
                    break;
                case 5:
                    fin = true;
                    System.out.println("\t\tHasta luego!");
                    break;
                default:
                    System.out.println("\t\tOpcion no valida, intente nuevamente.\n");

            }
        } while(!fin);
    }


    private static void mostrarMenu(){
        System.out.print("\n\t\t\u001B[33m\tTAREAS\u001B[0m\n" +
                "\t\t\u001B[33m1.\u001B[0m Nueva tarea\n" +
                "\t\t\u001B[33m2.\u001B[0m Mostrar tareas\n" +
                "\t\t\u001B[33m3.\u001B[0m Modificar tarea\n" +
//                "\t\t\u001B[33m4.\u001B[0m Verificar estado de tareas\n" +
                "\t\t\u001B[33m4.\u001B[0m Listado de tareas realizadas por colaborador\n" +
                "\t\t\u001B[33m5.\u001B[0m Salir\n" +
                "\n\t\tSeleccione una opcion: ");
    }
}