package Menu;
import java.util.List;
import java.util.Scanner;
public class Menu {
    // Funcion generica porque me canse de crear menus a mano, saracatunga
    // le paso los parametros: titulo, y una lista de opciones

    /**
     * Funcion generica para crear un menu
     * @param titulo
     * @param opciones
     * @autor DonChoton (miqueas)
     */
    public static int mostrarMenu(String titulo, List<String> opciones){
        Scanner escaner = new Scanner(System.in);

        boolean fin = false;

        do {
            System.out.println("\t\t" + AnsiColorsitos.YELLOW + titulo + AnsiColorsitos.RESET);

            int numero_de_opcion = 1;
            for (String i : opciones){
                System.out.println(AnsiColorsitos.YELLOW + numero_de_opcion + AnsiColorsitos.RESET + ". " + i);
                numero_de_opcion++;
            }

            System.out.println(AnsiColorsitos.YELLOW + "0" + AnsiColorsitos.RESET + ". Salir");
            System.out.print(AnsiColorsitos.YELLOW + "Ingrese una opcion: " + AnsiColorsitos.RESET);
            try {
                int respuesta = escaner.nextInt();
                if (respuesta >= 0 && respuesta <= opciones.size()){
                    if(respuesta == 0){
                        fin = true;
                        System.out.println(AnsiColorsitos.YELLOW + "Saliendo del programa..." + AnsiColorsitos.RESET);
                    }
                    return respuesta;
                } else{
                    System.err.println("Error, verifique el rango.");
                }
            } catch (Exception e){
                System.err.println("Error, ingrese un numero.");
                escaner.nextLine();
            }
        } while(!fin);
        return 0; // se activa si ingresa 0
    }
}
