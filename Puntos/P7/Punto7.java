package P7;

import java.util.Scanner;

public class Punto7 {
    public static void main(String[] args){
        Scanner escaner = new Scanner(System.in);
        System.out.print("Ingrese coeficiente a: ");
        double a = escaner.nextDouble();

        System.out.print("\nIngrese coeficiente b: ");
        double b = escaner.nextDouble();

        System.out.print("\nIngrese coeficiente c: ");
        double c = escaner.nextDouble();

        Ecuacion ecuacion = new Ecuacion(a, b, c);

        // Calcular las raíces de la ecuación.
        double[] raices = ecuacion.calcularRaices();
        if (raices.length == 0) {
            System.out.println("La ecuación no tiene raíces reales.");
        } else if (raices.length == 1) {
            System.out.println("Raíz única: " + raices[0]);
        } else {
            System.out.println("Raíz 1: " + raices[0]);
            System.out.println("Raíz 2: " + raices[1]);
        }

        // Calcular el valor de y para un valor dado de x.
        double x = 2.0;
        double y = ecuacion.calcularY(x);
        System.out.println("Para x=" + x + ", y=" + y);
    }
}
