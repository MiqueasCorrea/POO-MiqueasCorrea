package Nodo;

public class Nodo {
    //ATRIBUTOS
    private Object dato;
    private Nodo proximo = null;

    //CONSTRUCTORES
    /**
     * CONSTRUCTOR de una clase nodo
     */
    public Nodo(){
        this(null);
    }

    /**
     * CONSTRUCTOR de una clase Nodo
     * @param Object dato
     */
    public Nodo(Object dato){
        this(dato, null);
    }

    /**
     * CONSTRUCTOR de una clase Nodo
     * @param Object dato
     * @param Nodo proximo
     */
    public Nodo(Object dato, Nodo proximo){
        this.dato = dato;
        this.proximo = proximo;
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
    public Nodo getProximo(){
        return proximo;
    }


    //SETTERS
    /**
     * Modificar dato de la clase Nodo
     * @param Object dato
     */
    public void setDato(Object dato){
        this.dato = dato;
    }

    /**
     * Modificar el proximo de la clase Nodo
     * @param proximo
     */
    public void setProximo(Nodo proximo){
        this.proximo = proximo;
    }



}
