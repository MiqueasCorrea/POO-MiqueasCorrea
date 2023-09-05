package P1;

import Nodo.Nodo;

public class Listas {
    private Nodo primero = null;
    private int cantidad = 0;
    /**
     * CONSTRUCTOR de la clase Lista
     */
    public Listas(){
    }

    //AGREGAR
    /**
     * Agregar un nodo a la lista
     * @param Object dato
     */
    public void agregar(Object dato){
        Nodo nuevo_nodo = new Nodo(dato);

        if(primero == null){
            primero = nuevo_nodo;
        } else{
            Nodo aux = primero;
            while(aux.getProximo() != null){
                aux = aux.getProximo();
            }
            aux.setProximo(nuevo_nodo);
        }
        cantidad+=1;
    }

    /**
     * Verificar si es vacia
     * @return boolean
     */
    public boolean l_es_Vacia(){
        return primero == null;
    }

    /**
     * Retorna la cantidad de elementos(nodos) de la lista
     * @return int cantidad
     */
    public int l_longitud(){
        return cantidad;
    }

    /**
     * ELIMINAR un elemento(nodo) en base a posicion ordinal
     * @param int pos
     */
    public void l_eliminar(int pos){
        if(l_es_Vacia() == true) return;
        if((pos >= 1 && pos <= l_longitud()) == false) return;

        if(pos == 1){
            primero = primero.getProximo();
        } else{
            Nodo aux = primero;
            for(int i = 0; i < pos - 2; i++){
                aux= aux.getProximo();
            }
            aux.setProximo(aux.getProximo().getProximo());
        }
        cantidad-=1;
    }

    /**
     * INSERTAR un dato en una posicion ordinal
     * @param dato
     * @param pos
     */
    public void l_insertar(Object dato, int pos){

    }

    public Nodo l_recuperar(int pos){
        Nodo salida = new Nodo(null,null);
        if(l_es_Vacia() == true) return salida;
        if((pos>=1 && pos <= l_longitud()) == false) return salida;

        Nodo aux = primero;
        for(int i=0; i < pos -1; i++){
            aux.getProximo();
        }
        return aux;
    }

    /**
     * MOSTRAR la lista
     */
    public void l_mostrar(){
        Nodo aux = primero;
        int i=1;
        while(aux!=null){
            System.out.println("Nodo " + i + ": " + aux.getDato());
            aux = aux.getProximo();
            i++;
        }
    }


}
