package Classes;

public class ListaAdyacencia {
    Arco primero;
    Arco ultimo;

    public ListaAdyacencia(){
        primero = null;
        ultimo = null;
    }

    public boolean listaVacia(){
        return primero == null;
    }

    public void nuevaAdyacencia(Object destino){
        if(!adyacente(destino)){
            Arco nodo = new Arco(destino);
            inserta(nodo,destino);
        }
    }

    public void nuevaAdyacencia(Object destino, float peso){
        if(!adyacente(destino)){
            Arco nodo = new Arco(destino, peso);
            inserta(nodo,destino);
        }
    }

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
