package P3;
import Nodo.Nodo;
public class Pila {
    private Nodo tope;
    private int cantidad;

    public Pila(){
        tope = null;
        cantidad = 0;
    }

    public void p_apilar(Object dato){
        Nodo nodo = new Nodo();
        nodo.setDato(dato);
        nodo.setProximo(tope);
        tope = nodo;
        cantidad+=1;
    }

    public Object p_desapilar(){
        Nodo nodo = tope;
        tope = nodo.getProximo();
        return nodo.getDato();
    }

    public Object p_tope(){
        return tope.getDato();
    }

    public boolean p_es_vacia(){
        return tope == null;
    }

    public int p_longitud(){
        return cantidad;
    }

    public void p_mostrar(){
        System.out.println("Contenido de la pila:");
        if(p_es_vacia()){
            System.out.println("La pila es vacia, no se puede mostrar.");
        }
        Nodo nodo = tope;
        while(nodo!=null){
            System.out.println("" + nodo.getDato() + " ");
            nodo = nodo.getProximo();
        }
    }




}
