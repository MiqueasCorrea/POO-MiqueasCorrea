package P9;

import P9.Fecha;

import java.time.LocalDate;
import java.util.Scanner;

import static P9.Fecha.compararFechas;

public class Punto9{
    public static void main(String[] args){
        Fecha fecha1 = new Fecha();
        Fecha fecha2 = new Fecha();
        fecha1.pedirFecha();
        fecha2.pedirFecha();
        compararFechas(fecha1.getFecha(),fecha2.getFecha());
    }

}
