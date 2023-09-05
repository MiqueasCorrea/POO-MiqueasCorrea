import P5.Tarea;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Punto9{
    public static void main(String[] args){
        LocalDate fecha1 = pedirFecha();
        LocalDate fecha2 = pedirFecha();
        compararFechas(fecha1,fecha2);
    }

    public static LocalDate pedirFecha(){
        Scanner escaner = new Scanner(System.in);
        System.out.print("\u001B[33mIngrese fecha (yyyy-mm-dd)\u001B[0m: ");
        String fechaAux = escaner.nextLine();

        LocalDate fecha = LocalDate.parse(fechaAux);
        try{
            System.out.println("Fecha ingresada: " + fecha);
        } catch(Exception e2){
            System.err.println("Se produjo un error con la fecha, verifique el formato.\nCodigo de error: " +  e2.getMessage());
        }
        return fecha;
    }

    public static void compararFechas(LocalDate fecha1, LocalDate fecha2){
        if(fecha1.equals(fecha2)){
            System.out.println("Las fechas son iguales.");
            return;
        }
        if(fecha1.isAfter(fecha2)){
            System.out.println("Fecha 1:" + fecha1 + " es posterior a Fecha 2: " + fecha2);
        } else{
            System.out.println("Fecha 1:" + fecha1 + " es anterior a Fecha 2: " + fecha2);
        }
    }

}
