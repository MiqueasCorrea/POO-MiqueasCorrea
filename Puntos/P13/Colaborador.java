package P13;
import java.util.ArrayList;
import java.util.List;

public class Colaborador {
    private String nombre;
//    private List<Tarea> tareasRealizadas;

    public Colaborador(String nombre){
        this.nombre = nombre;
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
