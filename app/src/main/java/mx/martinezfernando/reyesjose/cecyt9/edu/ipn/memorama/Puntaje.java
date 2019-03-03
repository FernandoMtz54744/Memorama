package mx.martinezfernando.reyesjose.cecyt9.edu.ipn.memorama;

public class Puntaje {
    private String id;
    private String nombre;
    private String puntos;

    public Puntaje(String id, String nombre, String puntos) {
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }
}
