package P11;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diccionario {
    List<String> palabras;

    public Diccionario(){
        palabras = new ArrayList<>();
    }

    public List<String> getPalabras(){
        return this.palabras;
    }

    public void agrerarPalabraDiccionario(){
        boolean fin = false;
        Scanner respuesta = new Scanner(System.in);
        do {
            System.out.print("Ingrese una palabra a poner en el diccionario (digite 0 para salir): ");
            String palabra_a_validar = respuesta.nextLine();
            if(palabra_a_validar.equals("0")){
                fin = true;
            } else{
                this.palabras.add(palabra_a_validar);
            }
        } while(!fin);
    }

    public void mostrarPalabrasDiccionario(){
        for (String aux : palabras) {
            System.out.print("" + aux + " ");
        }
    }


}
