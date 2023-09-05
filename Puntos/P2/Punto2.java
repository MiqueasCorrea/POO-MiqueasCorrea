package P2;

import P2.ListasDobles;
import P2.NodoDoble;

public class Punto2 {
    public static void main(String[] args){
        ListasDobles lista = new ListasDobles();

        System.out.println("Agregamos algunos datos...");
        lista.l_agregar(2223);
        lista.l_agregar(154);
        lista.l_agregar(4524);
        lista.l_mostrar();


        System.out.println("\nEliminamos la primer posicion...");
        lista.l_eliminar(1);
        lista.l_mostrar();

        System.out.println("\nInsertamos en la posicion 1 un 777...");
        lista.l_insertar(1, 777);
        lista.l_mostrar();
    }
}
