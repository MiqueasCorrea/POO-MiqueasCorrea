import P11.Diccionario;
import P11.Jugador;

import java.util.Scanner;

public class Punto11{
    public static void main(String[] args){
        Diccionario diccionario = new Diccionario();
        Jugador jugador1 = new Jugador("Pepe");
        Jugador jugador2 = new Jugador("Saracatunga");

        System.out.println("Ingrese palabras para el diccionario.");
        diccionario.agrerarPalabraDiccionario();

        System.out.print("Palabras del diccionario:");
        diccionario.mostrarPalabrasDiccionario();

        System.out.println("\nPalabras del jugador 1: ");
        jugador1.pedirPalabra(diccionario);

        System.out.println("Palabras del jugador 2: ");
        jugador2.pedirPalabra(diccionario);

        if(jugador1.getPuntaje()>jugador2.getPuntaje()){
            System.out.println("El jugador " + jugador1.getNombre() + " tiene mas puntos que el jugador " + jugador2.getNombre());
        } else if(jugador1.getPuntaje()<jugador2.getPuntaje()){
            System.out.println("El jugador " + jugador2.getNombre() + " tiene mas puntos que el jugador " + jugador1.getNombre());
        } else{
            System.out.println("Ambos jugadores tienen los mismos puntos!");
        }
    }



}
