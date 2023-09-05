package P1;

import P1.Listas;

public class Punto1 {
    public static void main(String[] args){
        Listas lista = new Listas();

        System.out.println("Agregamos unos datos a la lista...");
        lista.agregar(24);
        lista.agregar(14);
        lista.agregar(2424);
        lista.agregar(241);
        lista.l_mostrar();

        System.out.println("\nEliminamos el primer dato..");
        lista.l_eliminar(1);
        lista.l_mostrar();

        System.out.println("\nInsertamos en la pos 2 el 777...");
        lista.l_insertar(777, 2);
        lista.l_mostrar();
    }
}
