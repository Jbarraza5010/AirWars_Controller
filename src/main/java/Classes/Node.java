package Classes;

/**
 * Esta clase define nodos para una lista enlazada
 */
public class Node {
    public Object data;
    public Node next;

    /**
     * Metodo constructor para la clase
     * @param data Elemento que contiene el nodo
     */
    public Node(Object data){
        this.next = null;
        this.data = data;
    }

    /**
     * Este metodo retorna el elemento de un nodo
     * @return Contenido de un nodo
     */
    public Object getData(){
        return this.data;
    }

    /**
     * Este metodo define el contenido de una nodo
     * @param data Es el elemento contenido en un nodo
     */
    public void setData(Object data){
        this.data = data;
    }

    /**
     * Este metodo retorna el nodo siguiente en una lista
     * @return Siguiente nodo en una lista
     */
    public Node getNext(){
        return this.next;
    }

    /**
     * Este metodo define el nodo siguiente en una lista
     * @param node Es el nodo siguiente en una lista
     */
    public void setNext(Node node){
        this.next = node;
    }
}
