package P8;
import java.util.Random;
public class Password {
    private int longitud;
    private String digitos = "2A1Ba1bC2c1Dd5E7eF9f0Gg7H7hI0iJjK7kLl9MmN0nO8oP0pQ7qR8rS4sT7tU8uV3vW8wX9xY2y1Zz4";
    private String contrasenia;
    private boolean seguro;

    public Password(){
        this(8);
    }
    public Password(int longitud){
        this.longitud = longitud;
        contrasenia = null;
        seguro = false;
    }

    //GETTERS
    public int getLongitud() {
        return longitud;
    }

    public String getDigitos() {
        return digitos;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public boolean getSeguro(){
        return seguro;
    }

    //SETTERS
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public void setDigitos(String digitos) {
        this.digitos = digitos;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    //METODOS
    public void generarContrasenia(){
        Random random = new Random();
        int numeroRandom;
        String nuevaPassword = "";
        for(int i=0; i < longitud; i++){
            numeroRandom = random.nextInt(digitos.length());
            nuevaPassword += digitos.charAt(numeroRandom);
        }
        contrasenia = nuevaPassword;
    }

    public boolean verificarConstrasenia(){
        if(contrasenia == null){
            System.err.println("No hay una contraseña establecida.");
            return this.seguro = false;
        }
        int mayusculas = 0, minusculas = 0, numeros = 0;
        for(int i = 0; i < contrasenia.length(); i++){
            char caracter = contrasenia.charAt(i);

            if(Character.isUpperCase(caracter)){
                mayusculas++;
            } else if(Character.isLowerCase(caracter)){
                minusculas++;
            } else if(Character.isDigit(caracter)){
                numeros++;
            }
        }

        if(mayusculas < 2 || minusculas < 1 || numeros < 2){
            System.out.print("<" + getContrasenia() + ">" + " - " + "\u001B[31mDébil\u001B[0m\n");

        } else{
            System.out.print("<" + getContrasenia() + ">" + " - " + "\u001B[32mFuerte\u001B[0m\n");
            this.seguro = true;
        }
        return this.seguro;
    }
}
