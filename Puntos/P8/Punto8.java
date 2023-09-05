package P8;

import P8.Password;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Punto8 {
    public static void main(String[] args){
        List<Password> contraseniasGeneradas = new ArrayList<>();
        boolean fin = false;


        do {
            Password contra = new Password();
            int respuesta;
            Scanner escaner = new Scanner(System.in);

            System.out.print("\n\nGENERADOR DE CONTRASENIAS\n" +
                               "1. Generar Contrasenia\n" +
                               "2. Mostrar claves generadas\n" +
                               "3. Salir\n" +
                               "\nIngrese respuesta: ");
            //Pido respuesta
            respuesta = escaner.nextInt();

            switch (respuesta){
                case 1:
                    System.out.print("Ingrese longitud de contraseña: ");
                    int longitud = escaner.nextInt();
                    contra.setLongitud(longitud);
                    contra.generarContrasenia();
                    System.out.print("Contrasenia generada: ");
                    contra.verificarConstrasenia();
                    contraseniasGeneradas.add(contra);
                    break;
                case 2:
                    System.out.println("Lista de contrasenias generadas: ");
                    mostrarContrasenias(contraseniasGeneradas);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    fin = true;
                    break;
                default:
                    System.err.println("Error, ingrese un digito valido.\n");
            }
        } while(!fin);


    }

    private static void mostrarContrasenias(List<Password> contraseniasGeneradas){
        for(int i=0; i<contraseniasGeneradas.size(); i++){
            Password contraAux = contraseniasGeneradas.get(i);
            System.out.print("Contrasenia " + i + ": ");
            contraAux.verificarConstrasenia();
        }
    }
}