package Classes;

/**
 * Esta clase define una lista enlazada compuesta por nodos
 */
public class LinkedList {
    private Node head;
    private Node last;
    private int size;

    /**
     * Metodo contructor para la clase
     */
    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    /**
     * Este metodo retorna si la lista es vacio o no
     * @return Valor booleano si la lista esta vacia o no
     */
    public boolean isEmpty(){
        return this.head ==  null;
    }

    /**
     * Este metodo retorna el tamaño de la lista
     * @return Tamaño de la lista
     */
    public int size() {
        return this.size;
    }

    /**
     * Este metodo recibe un objeto y lo inserta como primer elemento de la lista
     * @param data Nodo con valor objeto
     */
    public void insertFirst(Object data){
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    /**
     * Este metodo recibe un objeto y lo inserta como utlimo elemento de la lista
     * @param data Nodo con valor objeto
     */
    public void insertLast(Object data){
        Node newNode = new Node(data);
        newNode.next = null;
        if (isEmpty()){
            this.head = newNode;
            this.size++;
        }
        else{
            Node temp = new Node(null);
            temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            this.size ++;
        }
    }

    /**
     * Este metodo elimina el primer elemento de una lista
     * @return Lista sin el primer nodo
     */
    public Node deleteFirst(){
        if (this.head != null){
            Node temp = this.head;
            this.head = this.head.next;
            this.size--;
            return temp;
        }
        else{
            return null;
        }
    }

    /**
     * Este metodo hace un print de la lista actual
     */
    public void displayList(){
        Node current = this.head;
        while (current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    /**
     * Este metodo recibe un valor, lo busca en la lista y lo retorna
     * @param searchValue Elemento a buscar en la lista
     * @return Elemento encontrado en la lista
     */
    public Node find (Object searchValue){
        Node current = this.head;
        while (current != null){
            if (current.getData().equals(searchValue)){
                return current;
            }
            else{
                current = current.getNext();
            }
        }
        return null;
    }

    /**
     * Este metodo elimina un elemento definido en la lista
     * @param searchValue Elemento a eliminar de la lista
     * @return Lista sin el elemento definido
     */
    public Node delete (Object searchValue){
        Node current = this.head;
        Node previous = this.head;
        while (current != null){
            if (current.getData().equals(searchValue)){
                if (current == this.head){
                    this.head = this.head.getNext();
                }
                else{
                    previous.setNext(current.getNext());
                }
            }
            else{
                previous = current;
                current = current.getNext();
            }
            return current;
        }
        return null;
    }
}
