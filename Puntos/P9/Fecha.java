package P9;
import java.time.LocalDate;
import java.util.Scanner;

public class Fecha {
    private LocalDate fecha;

    //GETTERS
    public LocalDate getFecha() {
        return fecha;
    }

    //SETTERS
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    //METHODS
    public void pedirFecha(){
        Scanner escaner = new Scanner(System.in);
        System.out.print("\u001B[33mIngrese fecha (yyyy-mm-dd)\u001B[0m: ");
        String fechaAux = escaner.nextLine();

        LocalDate fecha = LocalDate.parse(fechaAux);
        try{
            System.out.println("Fecha ingresada: " + fecha);
        } catch(Exception e2){
            System.err.println("Se produjo un error con la fecha, verifique el formato.\nCodigo de error: " +  e2.getMessage());
        }
        this.fecha = fecha;
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
