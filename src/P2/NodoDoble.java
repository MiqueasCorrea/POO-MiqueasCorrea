package P2;

public class NodoDoble {
    //ATRIBUTOS
    private Object dato;
    private NodoDoble proximo;
    private NodoDoble anterior;

    //CONSTRUCTORES
    /**
     * CONSTRUCTOR de una clase nodo
     */
    public NodoDoble(){
        this(null);
    }

    /**
     * CONSTRUCTOR de una clase Nodo
     * @param Object dato
     */
    public NodoDoble(Object dato){
        this(dato, null);
    }

    /**
     * CONSTRUCTOR de una clase Nodo
     * @param Object dato
     * @param Nodo proximo
     */
    public NodoDoble(Object dato, NodoDoble proximo){
        this(dato, proximo, null);
    }

    /**
     * CONSTRUCTOR de una clase NodoDoble
     * @param dato
     * @param proximo
     * @param anterior
     */
    public NodoDoble(Object dato, NodoDoble proximo, NodoDoble anterior){
        this.dato = dato;
        this.proximo = proximo;
        this.anterior = anterior;
    }


    //GETTERS
    /**
     * Obtener dato de la clase Nodo
     * @return Object
     */
    public Object getDato(){
        return dato;
    }

    /**
     * Obtengo el proximo Nodo de la clase Nodo
     * @return Nodo
     */
    public NodoDoble getProximo(){
        return proximo;
    }

    public NodoDoble getAnterior(){
        return anterior;
    }
    //SETTERS
    /**
     * Modificar dato de la clase NodoDoble
     * @param Object dato
     */
    public void setDato(Object dato){
        this.dato = dato;
    }

    /**
     * Modificar el proximo de la clase NodoDoble
     * @param proximo
     */
    public void setProximo(NodoDoble proximo){
        this.proximo = proximo;
    }

    public void setAnterior(NodoDoble anterior){
        this.anterior = anterior;
    }
}
