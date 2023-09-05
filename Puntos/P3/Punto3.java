package P3;

import P3.Pila;
import P4.Cola;

public class Punto3 {
    public static void main(String[] args){
        Pila pila = new Pila();

        //Pruebas para ver si anda bien
        System.out.println("Apilamos algunos datos...\nMostrando Pila actual:");
        pila.p_apilar(223);
        pila.p_apilar(2343);
        pila.p_apilar(13);
        pila.p_mostrar();

        System.out.println("\nDesapilo y muestro: ");
        Object dato = pila.p_desapilar();
        System.out.println("Se desencolo el dato: " + dato);

        System.out.println("\nCola actual:");
        pila.p_mostrar();
    }
}
