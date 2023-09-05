package P4;

import P4.Cola;

public class Punto4 extends P4.Cola{
    public static void main(String[] args){
        Cola cola = new Cola();
        //Pruebas para ver si anda bien
        System.out.println("Encolamos algunos datos...\nMostrando Cola actual:");
        cola.c_encolar(11);
        cola.c_encolar(23);
        cola.c_encolar(22);
        cola.c_mostrar();

        System.out.println("\nDesencolo y muestro: ");
        Object dato = cola.c_desencolar();
        System.out.println("Se desencolo el dato: " + dato);

        System.out.println("\nCola actual:");
        cola.c_mostrar();

    }
}
