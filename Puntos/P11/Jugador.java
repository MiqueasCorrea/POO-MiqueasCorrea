package P11;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jugador{
    private String nombre;
    private int puntaje;

    public Jugador(String nombre){
        this.nombre     = nombre;
        puntaje         = 0;
    }

    public void pedirPalabra(Diccionario diccionario){
        boolean fin = false;
        Scanner respuesta = new Scanner(System.in);
        do {
            System.out.print("Palabra de " + nombre + " (digite 0 para salir): ");
            String palabra_a_validar = respuesta.nextLine();
            palabra_a_validar = palabra_a_validar.toLowerCase();
            if(palabra_a_validar.equals("0")){
                fin = true;
                break;
            }

            // Validar palabra
            List<String> palabrasDelDiccionario = diccionario.getPalabras();
            for(int i = 0; i < palabrasDelDiccionario.size(); i++){
                String aux = palabrasDelDiccionario.get(i);
                if(aux.equals(palabra_a_validar)){
                    //contabilizo los puntos si la palabra esta en el diccionario
                    int puntos = palabra_a_validar.length();
                    for(int j = 0; j < palabra_a_validar.length(); j++){
                        char caracter = palabra_a_validar.charAt(i);
                        if(caracter == 'k' || caracter == 'z' || caracter == 'x' || caracter == 'y' || caracter == 'w' || caracter == 'q'){
                            puntos+=1;
                        }
                    }
                    this.puntaje += puntos;
                    break;
                }
            }
        } while(!fin);
    }

    public int getPuntaje(){
        return puntaje;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }

    public void sumarPunjate(int puntaje_a_sumar){
        this.puntaje += puntaje_a_sumar;
    }
}
