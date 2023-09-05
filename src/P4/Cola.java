package P4;

import Nodo.Nodo;

public class Cola extends Nodo {
    private Nodo n_frente;
    private Nodo n_final;

    public Cola(){
    }

    public static boolean c_es_vacia(Cola cola){
        return cola.n_frente == null;
    }

    public static void c_encolar(Cola cola, Object dato){
        Nodo nuevo_nodo = new Nodo(dato);

        if(c_es_vacia(cola)){
            cola.n_frente = nuevo_nodo;
        } else{
            cola.n_final.setProximo(nuevo_nodo);
        }
        cola.n_final = nuevo_nodo;
    }

    public static Nodo c_desencolar(Cola cola){
        if(c_es_vacia(cola)){
            System.out.println("La cola esta vacia, no se puede desencolar.");
            return null;
        }
        Nodo frente = cola.n_frente;
        cola.n_frente = cola.n_frente.getProximo();
        return frente;
    }

    public static void c_mostrar(Cola cola){
        if(c_es_vacia(cola)){
            System.out.println("La cola esta vacia!");
            return;
        }
        Cola caux = new Cola();
        Nodo nodo = new Nodo();
        System.out.print("Contenido de la cola: ");

        while(!c_es_vacia(cola)){
            nodo = c_desencolar(cola);
            System.out.print("" + nodo.getDato());
            c_encolar(caux, nodo);
        }
        System.out.print("\n");
        while(!c_es_vacia(caux)){
            nodo = c_desencolar(caux);
            c_encolar(cola, nodo);
        }
    }
}
