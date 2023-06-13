package Classes;

public class ListaAdyacencia {
    Arco primero;
    Arco ultimo;

    /**
     * Constructor para crear una lista de adyacencia
     */
    public ListaAdyacencia(){
        primero = null;
        ultimo = null;
    }

    /**
     * Función para saber si la lista está vacía
     * @return
     */
    public boolean listaVacia(){
        return primero == null;
    }

    /**
     * Función para crear una nueva adyacencia entre nodos
     * @param destino
     */
    public void nuevaAdyacencia(Object destino){
        if(!adyacente(destino)){
            Arco nodo = new Arco(destino);
            inserta(nodo,destino);
        }
    }

    /**
     * Función para crear una nueva adyacencia entre nodos pero con peso
     * @param destino
     * @param peso
     */
    public void nuevaAdyacencia(Object destino, float peso){
        if(!adyacente(destino)){
            Arco nodo = new Arco(destino, peso);
            inserta(nodo,destino);
        }
    }

    /**
     * Función para insertar un nodo en la lista
     * @param nodo
     * @param destino
     */
    private void inserta(Arco nodo, Object destino) {
        if (listaVacia()) {
            primero = nodo;
            ultimo = nodo;
        } else {
            if (destino.toString().compareTo(primero.destino.toString()) <= 0) {
                nodo.siguiente = primero;
                primero = nodo;

            } else {
                if (destino.toString().compareTo(ultimo.destino.toString()) >= 0) {
                    ultimo.siguiente = nodo;
                    ultimo = nodo;
                } else {
                    Arco posicion = primero;
                    while (destino.toString().compareTo(posicion.destino.toString()) != 0) {
                        posicion = posicion.siguiente;
                    }
                    nodo.siguiente = posicion.siguiente;
                    posicion.siguiente = nodo;
                }
            }
        }
    }

    private Arco encuentraPosicion(Object dato){

        return null;
    }

    private Arco encuentraPosicionAnteriorDato(Object dato){

        return null;
    }

    private void eliminaPrincipio(){

    }

    private void eliminaFinal(){

    }

    private void eliminarEnmedio(Object dato, Arco pActual){

    }

    private void quitarAdyacencia(Object dato){

    }

    /**
     * Función para comprobar si existe adyacencia entre dos nodos
     * @param dato
     * @return
     */
    public boolean adyacente(Object dato){
        Arco actual;
        boolean encontrado;
        encontrado = false;
        actual = primero;
        while(actual != null && !dato.toString().equals((actual.destino.toString()))){
            actual = actual.siguiente;
        }
        if(actual != null){
            encontrado = true;
        }
        return encontrado;
    }

    /**
     * Función para crear símbolos en la prueba del grafo
     * @return
     */
    public String toString(){
        String cadena ="";
        Arco temporal = primero;
        while(temporal != null){
            cadena = cadena + temporal.destino.toString()+" ; ";
            temporal = temporal.siguiente;
        }
        return cadena;
    }
}
