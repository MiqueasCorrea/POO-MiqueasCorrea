package P4;

import Nodo.Nodo;

public class Cola extends Nodo {
    private Nodo n_frente = null;
    private Nodo n_final = null;
    private int cantidad;

    public Cola(){
        cantidad = 0;
    }

    public boolean c_es_vacia(){
        return n_frente == null;
    }

    public int c_longitud(){
        return cantidad;
    }

    public void c_encolar(Object dato){
        Nodo nuevo_nodo = new Nodo(dato);

        if(c_es_vacia()){
            n_frente = nuevo_nodo;
        } else{
            n_final.setProximo(nuevo_nodo);
        }
        cantidad+=1;
        n_final = nuevo_nodo;
    }

    public Object c_desencolar(){
        if(c_es_vacia()){
            System.out.println("La cola esta vacia, no se puede desencolar.");
            return null;
        }
        Nodo frente = n_frente;
        n_frente = n_frente.getProximo();
        cantidad-=1;
        return frente.getDato();
    }



    public void c_mostrar(){
        if(c_es_vacia()){
            System.out.println("La cola esta vacia!");
            return;
        }

        Nodo nodo = n_frente;

        while(nodo != null){
            System.out.print("" + nodo.getDato() + "\n");
            nodo = nodo.getProximo();
        }
    }

    public Object c_recuperar(){
        if(c_es_vacia()){
            System.out.println("La cola es vacia, no se puede recuperar el nodo.");
            return null;
        }
        return n_frente.getDato();
    }
}
