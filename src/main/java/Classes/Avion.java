package Classes;

public class Avion {
    private int velocidad;
    private int eficiencia;
    private int fortaleza;
    private int combustible;

    public Avion(int velocidad, int eficiencia, int fortaleza, int combustible){
        this.eficiencia = eficiencia;
        this.velocidad = velocidad;
        this.fortaleza = fortaleza;
        this.combustible = combustible;
    }
    public int getEficiencia() {
        return this.eficiencia;
    }
    public int getVelocidad() {
        return this.velocidad;
    }
    public int getFortaleza() {
        return this.fortaleza;
    }
    public int getCombustible() {
        return this.combustible;
    }
}
