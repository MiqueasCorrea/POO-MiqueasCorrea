import P2.ListasDobles;
import P2.NodoDoble;

public class Punto2 {
    public static void main(String[] args){
        ListasDobles lista = new ListasDobles();

        lista.l_agregar(22);
        lista.l_agregar(24);
        lista.l_agregar(24);
        lista.l_mostrar();

        lista.l_eliminar(2);
        lista.l_insertar(1,42424);

    }
}
