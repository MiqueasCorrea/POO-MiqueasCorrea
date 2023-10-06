package P6;
import java.time.LocalDate;
public class Venta {
    private LocalDate fecha;
    private Empleado empleado;
    private Expendedor tipo_expendedor;
    private float importe;
    private int cantidadLitros;
    private String patente;

    public Venta(LocalDate fecha, Empleado empleado, Expendedor tipo_expendedor, float importe, int cantidadLitros, String patente) {
        this.fecha = fecha;
        this.empleado = empleado;
        this.tipo_expendedor = tipo_expendedor;
        this.importe = importe;
        this.cantidadLitros = cantidadLitros;
        this.patente = patente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Expendedor getTipo_expendedor() {
        return tipo_expendedor;
    }

    public void setTipo_expendedor(Expendedor tipo_expendedor) {
        this.tipo_expendedor = tipo_expendedor;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public int getCantidadLitros() {
        return cantidadLitros;
    }

    public void setCantidadLitros(int cantidadLitros) {
        this.cantidadLitros = cantidadLitros;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
}
