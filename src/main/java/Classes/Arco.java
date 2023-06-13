package Classes;

public class Arco {
    Object destino;
    float peso;
    Arco siguiente;

    /**
     * Función para crear un arco
     * @param d
     */
    public Arco(Object d){
        destino = d;
        siguiente = null;
    }

    /**
     * Función para crear un arco pero con peso
     * @param d
     * @param p
     */
    public Arco(Object d, float p){
        destino = d;
        peso = p;
        siguiente = null;
    }
}
