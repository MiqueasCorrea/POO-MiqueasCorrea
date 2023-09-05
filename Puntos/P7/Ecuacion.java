package P7;

public class Ecuacion {
    private double a;
    private double b;
    private double c;

    public Ecuacion(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Metodo para calcular las raíces.
    public double[] calcularRaices() {
        double discriminante = b * b - 4 * a * c;
        if (discriminante > 0) {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            return new double[]{raiz1, raiz2};
        } else if (discriminante == 0) {
            double raizUnica = -b / (2 * a);
            //Crea y retorna un array
            return new double[]{raizUnica};
        } else {
            // No hay raíces reales.
            return new double[]{};
        }
    }

    public double calcularY(double x) {
        return a * x * x + b * x + c;
    }


}
