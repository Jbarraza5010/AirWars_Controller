package Classes;

public class Grafo {
    private NodoGrafo primero;
    private NodoGrafo ultimo;

    /**
     * Función para crear un grafo
     */
    public Grafo(){
        primero = null;
        ultimo = null;
    }

    /**
     * Función para comprobar si un grafo está vacío
     * @return
     */
    public boolean grafoVacio(){
        return primero == null;
    }

    /**
     * Función para comprobar si existe un vértice
     * @param dato
     * @return
     */
    public boolean existeVertice(Object dato){
        boolean existe = false;
        if(!grafoVacio()){
            NodoGrafo temporal = primero;
            while(temporal != null && !existe){
                if(temporal.dato.toString().equals(dato.toString())){
                    existe = true;
                }
                temporal = temporal.siguiente;
            }
        }
        return existe;
    }

    /**
     * Función para crear una arista del grafo
     * @param origen
     * @param destino
     */
    public void NuevaArista(Object origen, Object destino){
        if(existeVertice(origen) && existeVertice(destino)){
            NodoGrafo posicion = primero;
            while(!posicion.dato.equals(origen.toString())){
                posicion = posicion.siguiente;
            }
            posicion.lista.nuevaAdyacencia(destino);
        }
    }

    /**
     * Función para crear una arista con peso del grafo
     * @param origen
     * @param destino
     * @param peso
     */
    public void NuevaArista(Object origen, Object destino, float peso){
        if(existeVertice(origen) && existeVertice(destino)){
            NodoGrafo posicion = primero;
            while(!posicion.dato.equals(origen.toString())){
                posicion = posicion.siguiente;
            }
            posicion.lista.nuevaAdyacencia(destino, peso);
        }
    }

    /**
     * Función para crear un nuevo nodo
     * @param dato
     */
    public void nuevoNodo(Object dato){
        if(!existeVertice(dato)){
            NodoGrafo nodo = new NodoGrafo(dato);
            if(grafoVacio()){
                primero = nodo;
                ultimo = nodo;
            }else{
                if(dato.toString().compareTo(primero.dato.toString())<=0){
                    nodo.siguiente = primero;
                    primero = nodo;
                }else{
                    if(dato.toString().compareTo(ultimo.dato.toString())>=0){
                        ultimo.siguiente = nodo;
                        ultimo = nodo;
                    }else{
                        NodoGrafo temporal = primero;
                        while(dato.toString().compareTo(temporal.dato.toString())!=0){
                            temporal = temporal.siguiente;
                        }
                        nodo.siguiente = temporal.siguiente;
                        temporal.siguiente = nodo;
                    }
                }
            }
        }
    }

    /**
     * Función para generar una figura tipo flecha
     * @return
     */
    public String toString(){
        String cadena = "";
        NodoGrafo temporal = primero;
        while(temporal != null){
            cadena = cadena + temporal.dato.toString()+" -> " + temporal.lista.toString()+"\n";
            temporal = temporal.siguiente;
        }
        return cadena;
    }
}
