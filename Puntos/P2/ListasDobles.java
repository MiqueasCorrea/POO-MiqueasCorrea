package P2;

public class ListasDobles {
    private NodoDoble primero;
    private int cantidad;

    /**
     * CONSTRUCTOR de la clase Lista doble
     */
    public ListasDobles(){
        this.primero  = null;
        this.cantidad = 0;
    }

    public boolean l_es_Vacia(){
        return primero == null;
    }

    public int l_longitud(){
        return cantidad;
    }

    public void l_agregar(Object dato){
        NodoDoble nodo = new NodoDoble(dato);

        if(l_es_Vacia()){
            primero = nodo;
        } else{
            NodoDoble aux = primero;
            while(aux.getProximo() != null){
                aux = aux.getProximo();
            }
            aux.setProximo(nodo);
            nodo.setAnterior(aux);
        }
        cantidad+=1;
    }

    public void l_eliminar(int pos){
        if(l_es_Vacia()) return;
        if(!(pos >= 1 && pos <= l_longitud())) return;

        NodoDoble nodo = new NodoDoble();
        if(pos == 1){
            primero.setAnterior(nodo);
            primero = primero.getProximo();
        } else{
            NodoDoble aux = primero;
            for(int i = 0; i < pos - 1; i++){
                aux = aux.getProximo();
            }
            NodoDoble anterior = aux.getAnterior();
            anterior.setProximo(aux.getProximo());
        }
        cantidad -= 1;
    }

    public NodoDoble l_recuperar(int pos){
        if(l_es_Vacia()) return null;
        if(!(pos >= 1 && pos <= l_longitud())) return null;

        NodoDoble aux = primero;
        for(int i = 0; i < pos - 1; i++){
            aux = aux.getProximo();
        }
        return aux;
    }

    public void l_insertar(int pos, Object dato){
        if(l_es_Vacia()) return;
        if(!(pos >= 1 && pos <= l_longitud())) return;

        NodoDoble nodo = new NodoDoble(dato);
        if(pos == 1){
            nodo.setProximo(primero);
            primero = nodo;
        } else{
            NodoDoble aux = primero;
            for(int i=0; i < pos - 1; i++){
                aux = aux.getProximo();
            }
            NodoDoble anterior = aux.getAnterior();
            anterior.setProximo(nodo);
            nodo.setProximo(aux);
        }
        cantidad += 1;
    }

    public void l_mostrar(){
        if(l_es_Vacia()) return;

        NodoDoble aux = primero;
        while(aux!=null){
            System.out.println("" + aux.getDato());
            aux = aux.getProximo();
        }
    }
}
